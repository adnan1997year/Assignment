package test;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class NoiseRemoval {

    public static void blur(Mat src) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
             
        Mat dst = src.clone();
        Imgproc.blur(src, dst, new Size(9,9), new Point(-1, -1), Core.BORDER_DEFAULT);
        Imgcodecs.imwrite("C:/img/b160_1.png", dst);

    }

    public static void GaussianBlur(Mat src) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat dst = src.clone();
        Imgproc.GaussianBlur(src, dst, new Size(9,9), 0, 0, Core.BORDER_DEFAULT);
        Imgcodecs.imwrite("C:/img/b160_1.png", dst);
    }

    public static void medianBlur(Mat src) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat dst = src.clone();
        Imgproc.medianBlur(src, dst, 7);
        Imgcodecs.imwrite("C:/img/b160_1.png", dst);
    }
}
