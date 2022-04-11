import com.sun.rowset.internal.Row;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;

import java.io.*;

public class Demo {
    public static void main(String[] args) throws IOException, BiffException {

        File file;
        InputStream cp = new FileInputStream("");
        InputStream iems = new FileInputStream("");
        Workbook wbcp = Workbook.getWorkbook(cp);
        Workbook wbiems = Workbook.getWorkbook(iems);
        Sheet lotIdSheet = wbiems.getSheet(1).getColumn();
        Sheet  waferListSheet= wbiems.getSheet("WAFERLIST");
        Sheet cplotIdSheet = wbcp.getSheet("LOT_ID");
        Sheet cpWaferIDSheet = wbcp.getSheet("WAFER_ID");
        Sheet cpYieldSheet = wbcp.getSheet("CP1_YIELD");
    }

    public String getIemsResultByLotID(Sheet lotIdSheet,Sheet waferListSheet){
        //获取行数
        int rows = lotIdSheet.getRows();
        for(int i=0;i<rows;i++){
            Cell[] row = lotIdSheet.getRow(i);

        }
        return "";
    }
    public  double average(double[] array) {
        double sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }
}
