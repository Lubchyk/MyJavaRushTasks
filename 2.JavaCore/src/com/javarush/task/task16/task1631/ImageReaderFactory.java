package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by mlv on 25.04.2017.
 */
public class ImageReaderFactory {


    public static ImageReader getImageReader(ImageTypes type) {

        if (type == ImageTypes.JPG) return new JpgReader();
        if (type == ImageTypes.BMP) return new BmpReader();
        if (type == ImageTypes.PNG) return new PngReader();
        else throw new IllegalArgumentException();

    }

}
