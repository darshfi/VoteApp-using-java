import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class BackEnd {
    static int[] votes = new int[16];
    static String fileI = "C:\\Users\\darsh\\IdeaProjects\\Computer Project\\src\\election.xlsx";

    public static void initialize(){
        // Reading file from local directory
        FileInputStream file;
        try {
            file = new FileInputStream(
                    fileI);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        // Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        // Get first/desired sheet from the workbook
        Sheet sheet = workbook.getSheet("Votes");

        // HeadBoy
        votes[0] = (int) sheet.getRow(1).getCell(2).getNumericCellValue();
        votes[1] = (int) sheet.getRow(2).getCell(2).getNumericCellValue();
        votes[2] = (int) sheet.getRow(3).getCell(2).getNumericCellValue();
        votes[3] = (int) sheet.getRow(4).getCell(2).getNumericCellValue();
        // HeadGirl
        votes[4] = (int) sheet.getRow(6).getCell(2).getNumericCellValue();
        votes[5] = (int) sheet.getRow(7).getCell(2).getNumericCellValue();
        votes[6] = (int) sheet.getRow(8).getCell(2).getNumericCellValue();
        votes[7] = (int) sheet.getRow(9).getCell(2).getNumericCellValue();
        // Vice-HeadBoy
        votes[8] = (int) sheet.getRow(11).getCell(2).getNumericCellValue();
        votes[9] = (int) sheet.getRow(12).getCell(2).getNumericCellValue();
        votes[10] = (int) sheet.getRow(13).getCell(2).getNumericCellValue();
        votes[11] = (int) sheet.getRow(14).getCell(2).getNumericCellValue();
        // Vice-HeadGirl
        votes[12] = (int) sheet.getRow(16).getCell(2).getNumericCellValue();
        votes[13] = (int) sheet.getRow(17).getCell(2).getNumericCellValue();
        votes[14] = (int) sheet.getRow(18).getCell(2).getNumericCellValue();
        votes[15] = (int) sheet.getRow(19).getCell(2).getNumericCellValue();

        try {
            file.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        // Writing the workbook
        FileOutputStream out;
        try {
            out = new FileOutputStream(
                    fileI);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        try {
            workbook.write(out);
            out.close();
            workbook.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void submitVote() {
        votes[0] += FrontEnd.headBoyOptions[0].isSelected() ? 1 : 0;
        votes[1] += FrontEnd.headBoyOptions[1].isSelected() ? 1 : 0;
        votes[2] += FrontEnd.headBoyOptions[2].isSelected() ? 1 : 0;
        votes[3] += FrontEnd.headBoyOptions[3].isSelected() ? 1 : 0;
        votes[4] += FrontEnd.headGirlOptions[0].isSelected() ? 1 : 0;
        votes[5] += FrontEnd.headGirlOptions[1].isSelected() ? 1 : 0;
        votes[6] += FrontEnd.headGirlOptions[2].isSelected() ? 1 : 0;
        votes[7] += FrontEnd.headGirlOptions[3].isSelected() ? 1 : 0;
        votes[8] += FrontEnd.viceHeadBoyOptions[0].isSelected() ? 1 : 0;
        votes[9] += FrontEnd.viceHeadBoyOptions[1].isSelected() ? 1 : 0;
        votes[10] += FrontEnd.viceHeadBoyOptions[2].isSelected() ? 1 : 0;
        votes[11] += FrontEnd.viceHeadBoyOptions[3].isSelected() ? 1 : 0;
        votes[12] += FrontEnd.viceHeadGirlOptions[0].isSelected() ? 1 : 0;
        votes[13] += FrontEnd.viceHeadGirlOptions[1].isSelected() ? 1 : 0;
        votes[14] += FrontEnd.viceHeadGirlOptions[2].isSelected() ? 1 : 0;
        votes[15] += FrontEnd.viceHeadGirlOptions[3].isSelected() ? 1 : 0;

        for(int i = 0; i<4; i++){
            FrontEnd.headBoyOptions[i].setSelected(false);
            FrontEnd.headGirlOptions[i].setSelected(false);
            FrontEnd.viceHeadBoyOptions[i].setSelected(false);
            FrontEnd.viceHeadGirlOptions[i].setSelected(false);
        }
    }

    public static void saveResults() {
        // Reading file from local directory
        FileInputStream file;
        try {
            file = new FileInputStream(
                    fileI);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        // Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        // Get first/desired sheet from the workbook
        Sheet sheet = workbook.getSheet("Votes");

        // HeadBoy
        sheet.getRow(1).getCell(2).setCellValue(votes[0]);
        sheet.getRow(2).getCell(2).setCellValue(votes[1]);
        sheet.getRow(3).getCell(2).setCellValue(votes[2]);
        sheet.getRow(4).getCell(2).setCellValue(votes[3]);
        // HeadGirl
        sheet.getRow(6).getCell(2).setCellValue(votes[4]);
        sheet.getRow(7).getCell(2).setCellValue(votes[5]);
        sheet.getRow(8).getCell(2).setCellValue(votes[6]);
        sheet.getRow(9).getCell(2).setCellValue(votes[7]);
        // Vice-HeadBoy
        sheet.getRow(11).getCell(2).setCellValue(votes[8]);
        sheet.getRow(12).getCell(2).setCellValue(votes[9]);
        sheet.getRow(13).getCell(2).setCellValue(votes[10]);
        sheet.getRow(14).getCell(2).setCellValue(votes[11]);
        // Vice-HeadGirl
        sheet.getRow(16).getCell(2).setCellValue(votes[12]);
        sheet.getRow(17).getCell(2).setCellValue(votes[13]);
        sheet.getRow(18).getCell(2).setCellValue(votes[14]);
        sheet.getRow(19).getCell(2).setCellValue(votes[15]);

        //closing the input file (this is what takes the data from the sheet)
        try {
            file.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        // Writing the workbook
        FileOutputStream out;
        try {
            out = new FileOutputStream(
                    fileI);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        try {
            workbook.write(out);
            out.close();
            workbook.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
