package pa04.view;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import pa04.model.Histogram;

public class HistogramDisplay <T> extends ApplicationFrame {
    private final Histogram<T> histogram;
   
    public HistogramDisplay(Histogram<T> histogram) {
        super("Histograma");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }
    
    public void execute(){
        setVisible(true);
    }
    
    private JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500,400));       
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart(
                "Histograma de emails",
                "dominios email",
                "n* de emails recibidos",
                dataSet,
                PlotOrientation.VERTICAL,
                false,
                rootPaneCheckingEnabled,
                rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
       DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
       //ctrl+shift+strzalka w dol
       for (T key : histogram.keySet()) {
           dataSet.addValue(histogram.get(key), "", (Comparable) key);
       }
       return dataSet;
    }
    
}
