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
        Cell[] iemslotId = wbiems.getSheet(1).getColumn(1);
        Cell[]  iemswaferList= wbiems.getSheet("WAFERLIST").getColumn(11);
        Cell[] cplotId = wbcp.getSheet("LOT_ID").getColumn(0);
        Cell[] cpWaferID = wbcp.getSheet("WAFER_ID").getColumn(1);
        Cell[] cpYield = wbcp.getSheet("CP1_YIELD").getColumn(5);
    }

    public String getIemsResultByLotID(Cell[] iemslotId,Cell[]  iemswaferList,Cell[] cplotId,Cell[] cpWaferID,Cell[] cpYield){
        //获取行数
        int iemsrows = iemslotId.length;
        for(int i=0;i<iemsrows;i++){
            String lotID = iemslotId[i].getContents();
            String waferList =iemswaferList[i].getContents();
            String[] waferArray = waferList.split(" ");
            int waferArrayRows = waferArray.length;
            int cprows = cplotId.length;
            double sum = 0;
            int count = 0;
            for(int j=0;j<cprows;j++){
                String WaferID = cpWaferID[j].getContents();
                double Yield = Double.parseDouble(cpYield[j].getContents());
                if (lotID.equals(cplotId[j])){
                    for(int x=0;x<waferArrayRows;x++){
                        if(waferArray[x]==WaferID){
                            sum+=Yield;
                            count+=1;
                        }
                    }
               }
            }
            double result = sum / count;
            System.out.println("LotID:"+lotID+"-------result:"+result);
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
