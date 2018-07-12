package com.agit.crm.main.viewmodel.customer.feedback;

import org.zkoss.chart.Chart;
import org.zkoss.chart.Charts;
import org.zkoss.chart.Point;
import org.zkoss.chart.Series;
import org.zkoss.chart.plotOptions.PiePlotOptions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

/**
 *
 * @author lintang
 */
public class PieDonutComposer extends SelectorComposer<Window> {

    @Wire
    Charts chart;

    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);

        Chart chartOptional = chart.getChart();
        chartOptional.setPlotBorderWidth(0);
        chartOptional.setPlotShadow(false);

        chart.getTooltip().setPointFormat(
                "{series.name}: <b>{point.percentage:.1f}%</b>");

        PiePlotOptions plotOptions = chart.getPlotOptions().getPie();
        plotOptions.setAllowPointSelect(true);
        plotOptions.setCursor("pointer");
        plotOptions.getDataLabels().setEnabled(false);
        plotOptions.setShowInLegend(true);

        Series series = chart.getSeries();
        series.setType("pie");
        series.setName("Browser share");
        series.addPoint(new Point("Sangat Puas", 45.0));
        series.addPoint(new Point("Puas", 26.8));
        Point point = new Point("Kurang Puas", 12.8);
        point.setSliced(true);
        point.setSelected(true);
        series.addPoint(point);
        series.addPoint(new Point("Kecewa", 8.5));
//        series.addPoint(new Point("Opera", 6.2));
//        series.addPoint(new Point("Others", 0.7));
    }
}
