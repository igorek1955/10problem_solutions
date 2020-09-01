package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public  class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) throws IllegalArgumentException {
        ImageReader reader = null;
        try{
            if(type.equals(ImageTypes.JPG)){
                reader = new JpgReader();
            }else if(type.equals(ImageTypes.BMP)) reader = new BmpReader();
            else if(type.equals(ImageTypes.PNG)) reader = new PngReader();
        } catch (Exception e){
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return reader;
    }
}
