/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.main.viewmodel;

import org.zkoss.chart.Chart;
import org.zkoss.chart.Charts;
import org.zkoss.chart.Point;
import org.zkoss.chart.Series;
import org.zkoss.chart.plotOptions.PieDataLabels;
import org.zkoss.chart.plotOptions.PiePlotOptions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

/**
 *
 * @author Zaky
 */
public class DashboardPieChartVM extends SelectorComposer<Window> {

    @Wire
    Charts chart;
    
    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);
        
        Series series = chart.getSeries();
        series.setType("pie");
        series.setName("Browser share");
        series.addPoint(new Point("Firefox", 45.0));
        series.addPoint(new Point("IE", 26.8));
        Point chrome = new Point("Chrome", 12.8);
        chrome.setSelected(true);
        chrome.setSliced(true);
        series.addPoint(chrome);
        series.addPoint(new Point("Safari", 8.5));
        series.addPoint(new Point("Opera", 6.2));
        series.addPoint(new Point("Others", 0.7));
        
        Chart chartOptional = chart.getChart();
        chartOptional.setPlotBorderWidth(0);
        chartOptional.setPlotShadow(false);
        
        chart.getTooltip().setPointFormat(
            "{series.name}: <b>{point.percentage:.1f}%</b>");
        
        PiePlotOptions plotOptions = chart.getPlotOptions().getPie();
        
        plotOptions.setAllowPointSelect(true);
        plotOptions.setCursor("pointer");
        PieDataLabels dataLabels = (PieDataLabels)plotOptions.getDataLabels();
        dataLabels.setEnabled(true);
        dataLabels.setFormat("<b>{point.name}</b>: {point.percentage:.1f} %");
    }
}
