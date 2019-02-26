package ProgramacionLineal;

import org.jfree.chart.axis.NumberAxis;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author ovall
 */

public class Graficar {
        JFreeChart grafica;
        XYSeries series;
        XYSeriesCollection datos = new XYSeriesCollection();
    
    public Graficar() {
//        xyplot = new XYPlot(datos,new NumberAxis("x"),new NumberAxis("y"),r);
//        xyplot.setDomainGridlinesVisible(true);
//        xyplot.setRangeGridlinesVisible(true);
        grafica = ChartFactory.createXYLineChart("","","",datos,
                            PlotOrientation.VERTICAL,true,false,false);
    }
  
    public void agregarGrafica(String id, double x, double y) {
        series = new XYSeries(id);
        series.add(x,0);
        series.add(0,y);
        datos.addSeries(series);
    }
  
    public void BorrarGrafica() {
        datos.removeAllSeries();
    }

    public JPanel obtenerGrafica() {
        return new ChartPanel(grafica);
    }
}
