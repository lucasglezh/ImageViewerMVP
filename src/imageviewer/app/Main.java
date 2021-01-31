package imageviewer.app;

import imageviewer.control.ImagePresenter;
import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import imageviewer.view.ImageLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame implements ImageLoader{
    
    private List<Image> images;
    private ImageDisplay imageDisplay; 
    private ImagePresenter imagePresenter;

    public static void main(String[] args) {
        new Main().execute();
    }
    
    public Main(){
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(createImagePanel());
        this.imagePresenter = new ImagePresenter(images, imageDisplay);
    }

    private void execute() {
        this.images = new FileImageLoader(new File("fotos")).load();
        this.imageDisplay.display(images.get(0));
        this.setVisible(true);
    }

    private JPanel createImagePanel() {
        ImagePanel imagePanel = new ImagePanel();
        this.imageDisplay = imagePanel;
        return imagePanel;
    }

    @Override
    public List<Image> load() {
        List<Image> list = new ArrayList<>();
        list.add(new Image("fotos/ulpgc1.jpg"));
        list.add(new Image("fotos/ulpgc2.png"));
        list.add(new Image("fotos/ulpgc3.jpg"));
        return list;
    }
}
