package imageviewer.control;

import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import java.util.List;

public class ImagePresenter {
    private final List<Image> images;
    private final ImageDisplay imageDisplay;

    public ImagePresenter(List<Image> images, ImageDisplay imageDisplay) {
        this.images = images;
        this.imageDisplay = imageDisplay;
        this.imageDisplay.on(shift());
    }

    public ImagePresenter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ImageDisplay.Shift shift() {
        return new ImageDisplay.Shift(){
            @Override
            public Image left() {
                return images.get((current() + 1) % images.size());
            }

            @Override
            public Image right() {
                return images.get((current() - 1 + images.size()) % images.size());
            }

            private int current() {
                return images.indexOf(imageDisplay.image());
            }
        };
    }
}
