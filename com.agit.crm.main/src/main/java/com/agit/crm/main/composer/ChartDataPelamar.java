/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.main.composer;

/**
 *
 * @author BayuHS
 */
import org.zkoss.chart.Charts;
import org.zkoss.chart.Legend;
import org.zkoss.chart.YAxis;
import org.zkoss.chart.model.CategoryModel;
import org.zkoss.chart.model.DefaultCategoryModel;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

/**
 *
 * @author lintang
 */
public class ChartDataPelamar extends SelectorComposer<Window> {

    @Wire
    Charts chart;

    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);

        CategoryModel catmodel = new DefaultCategoryModel();

        catmodel.setValue("Applicant's rating", "Spring", new Integer(20));
        catmodel.setValue("Applicant's rating", "Hibernate", new Integer(30));
        catmodel.setValue("Applicant's rating", "SQL", new Integer(40));
        catmodel.setValue("Applicant's rating", "Android", new Integer(50));
        catmodel.setValue("Applicant's rating", "Java Script", new Integer(20));
        catmodel.setValue("Applicant's rating", "PHP", new Integer(30));
        catmodel.setValue("Maximum Value", "Spring", new Integer(100));
        catmodel.setValue("Maximum Value", "Hibernate", new Integer(100));
        catmodel.setValue("Maximum Value", "SQL", new Integer(100));
        catmodel.setValue("Maximum Value", "Android", new Integer(100));
        catmodel.setValue("Maximum Value", "Java Script", new Integer(100));
        catmodel.setValue("Maximum Value", "PHP", new Integer(100));
        chart.setModel(catmodel);

        chart.getTitle().setX(-80);

        chart.getPane().setSize("80%");

        chart.getXAxis().setTickmarkPlacement("on");
        chart.getXAxis().setLineWidth(0);

        YAxis yAxis = chart.getYAxis();
        yAxis.setGridLineInterpolation("polygon");
        yAxis.setLineWidth(0);
        yAxis.setMin(0);

        chart.getTooltip().setShared(true);
        chart.getTooltip().setPointFormat(
                "<span style=\"color:{series.color}\">"
                + "{series.name}: <b>{point.y:,.0f}%</b><br/>");

        Legend legend = chart.getLegend();
        legend.setAlign("right");
        legend.setVerticalAlign("top");
        legend.setY(70);
        legend.setLayout("vertical");

        chart.getPlotOptions().getSeries().setPointPlacement("on");

    }
}
