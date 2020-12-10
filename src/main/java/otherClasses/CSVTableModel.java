package otherClasses;

import java.util.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;


/**
 *
 * @author Admin
 */
public class CSVTableModel extends AbstractTableModel{


    private String[] columnTitle;
    private List<Map<String, String>> artikelData;

    public CSVTableModel() {
        artikelData = new ArrayList<Map<String, String>>() ;

    }
    public void addData(List<Map<String, String>> artikelData){
        this.artikelData = artikelData;

        fireTableRowsInserted(artikelData.size()-1, artikelData.size()-1);
    }

    @Override
    public int getRowCount() {

        return artikelData.size();
    }
    @Override
    public int getColumnCount() {
        return columnTitle.length;
    }

    public Object getValueAtRow(int row){
        Object csvFile = (Object)artikelData.get(row);
        return csvFile;
    }

    public String[] getColumnTitle() {
        return columnTitle;
    }

    public void setColumnTitle(String[] spaltenTitle) {
        this.columnTitle = spaltenTitle;
    }

    public List<Map<String, String>> getCSVData() {
        return artikelData;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return artikelData.get(rowIndex).get(columnIndex)   ;
    }


//    enum Header {
//        Hauptartikelnr(0), ArtikelName(1), Hersteller(2),Beschreibung(3)
//        ,Materialangaben(4),Geschlecht(5),Produktart(6),Ärmel(7),Bein(8),Kragen(9),Herstellung(10)
//        ,Taschenart(11),Grammatur(12),Material(13),Ursprungsland(14),Bildname(15);
//
//        private int columnIndex;
//
//        Header(int columnIndex){
//            this.columnIndex = columnIndex;
//        }
//
//        public int columnIndex(){
//            return columnIndex;
//        }
//    }

}
