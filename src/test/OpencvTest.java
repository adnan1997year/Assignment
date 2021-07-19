package test;

import java.awt.FileDialog;
import java.io.File;
import java.io.PrintStream;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class OpencvTest {

    public static void main(String[] args) {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
        FileDialog fd = new FileDialog(new javax.swing.JFrame(), "Choose a file", FileDialog.LOAD);
        fd.setDirectory("C:\\");
        fd.setFile("*.jpg");
        fd.setVisible(true);
        String filename = fd.getDirectory() + fd.getFile();
        if (filename == null) {
            return;
        }
        
         Mat src = Imgcodecs.imread(filename);
  
        // New matrix to store the final image
        // where the input image is supposed to be written
        Mat dst = new Mat();
  
        // Scaling the Image using Resize function
        Imgproc.resize(src, dst, new Size(0, 0), 0.1, 0.1,
                       Imgproc.INTER_AREA);
  
        // Writing the image from src to destination
        Imgcodecs.imwrite("C:/img/b160_1.png", dst);
  
        src = Imgcodecs.imread(filename, Imgcodecs.IMREAD_GRAYSCALE);
        Imgcodecs.imwrite("C:/img/b160_1.png", src);
        
        Mat target = new Mat();
        Imgproc.threshold(src, target, 0, 255, Imgproc.THRESH_BINARY | Imgproc.THRESH_OTSU);
        Imgcodecs.imwrite("C:/img/b160_1.png", target);
        
//        NoiseRemoval.blur(target);
//        src = Imgcodecs.imread("C:/img/b160_1.png");
//        NoiseRemoval.GaussianBlur(src);
        src = Imgcodecs.imread("C:/img/b160_1.png");
        NoiseRemoval.GaussianBlur(src);
        
//        src = Imgcodecs.imread("C:/img/b160_1.png");
//        Quadrangle quad = new Quadrangle();
//        System.out.println(src);
//        src = quad.warp(src);
        
        Imgcodecs.imwrite("C:/img/b160_1.png", src);
//        src = Imgcodecs.imread("C:/img/b160_1.png");
//        NoiseRemoval.medianBlur(src);

        
        Tesseract tesseract = new Tesseract();
        try {
            tesseract.setDatapath(System.getProperty("user.dir") + "/datalang");

            String text = tesseract.doOCR(new File(filename));
            
            
            File f = new File("file.txt");
            PrintStream p = new PrintStream(f);
            p.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
