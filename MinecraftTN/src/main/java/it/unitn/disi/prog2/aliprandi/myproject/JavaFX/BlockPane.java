package it.unitn.disi.prog2.aliprandi.myproject.JavaFX;

import it.unitn.disi.prog2.aliprandi.myproject.data.TorchBlock;
import it.unitn.disi.prog2.aliprandi.myproject.interfaces.Block;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.image.Image;

import static java.lang.String.valueOf;

public class BlockPane extends StackPane {

    private Block block;
    public static final int DIM_SQUARE = 50;
    private static final String FONT_NAME = "Verdana";
    private static final int FONT_SIZE = 18;
    private static final FontWeight FONT_WEIGHT = FontWeight.BOLD;
    private static final Color BLOCK_BORDER = Color.BLACK;
    private static final Color FONT_FILL = Color.BLACK;
    private static final Color FONT_BORDER = Color.BLACK;

    public ImageView imgv;

    public BlockPane(Block block) {
        this.block = block;

        initialise();

        Image img = getImage(block);

        this.imgv = new ImageView();
        this.imgv.setImage(img);
        this.imgv.setFitWidth(50);
        this.imgv.setFitHeight(50);

        this.getChildren().add(this.imgv);

    }

    public Block getBlock() {
        return this.block;
    }

    private void initialise() {

        Rectangle r = new Rectangle(DIM_SQUARE,DIM_SQUARE);
        r.setFill(getColor(this.block));
        //r.setStroke(FONT_BORDER);
        //r.setStrokeWidth(2);

        Text text = new Text(valueOf(block.display()));
        text.setFont(Font.font(FONT_NAME, FONT_WEIGHT, FONT_SIZE));
        text.setFill(FONT_FILL);

        this.getChildren().add(r);

        this.getChildren().add(text);
    }

    public void changeBlock(Block b) {
        this.block=b;

        initialise();
    }

    public static Color getColor(Block block) {
        char c = block.display();
        Color color = null;

        Image image = null;

        if (c=='.') {
            color=Color.LIGHTBLUE;
        } else if (c=='S') {
            color=Color.SANDYBROWN;

        } else if (c=='G') {
            color=Color.WHITESMOKE;

        } else if (c=='F') {
            color=Color.GRAY;

        } else if (c=='T') {
            color=Color.ORANGE;
        } else if (c=='W') {
            color=Color.BLUE;

        } else {
            color=Color.BLUE;
        }

        return color;
    }

    public static Image getImage(Block block) {

        String path;
        Image img = null;

        try {
            char c = block.display();

            if (c == '.') {
                path = "file:/Users/paoloaliprandi/NetBeansProjects/myProject/src/main/java/it/unitn/disi/prog2/aliprandi/myproject/JavaFX/Images/air.png";
            } else if (c == 'S') {
                path = "file:/Users/paoloaliprandi/NetBeansProjects/myProject/src/main/java/it/unitn/disi/prog2/aliprandi/myproject/JavaFX/Images/sand.jpeg";
            } else if (c == 'G') {
                path = "file:/Users/paoloaliprandi/NetBeansProjects/myProject/src/main/java/it/unitn/disi/prog2/aliprandi/myproject/JavaFX/Images/glass.png";
            } else if (c == 'F') {
                path = "file:/Users/paoloaliprandi/NetBeansProjects/myProject/src/main/java/it/unitn/disi/prog2/aliprandi/myproject/JavaFX/Images/raw_iron.png";
            } else if (c == 'T') {
                path = "file:/Users/paoloaliprandi/NetBeansProjects/myProject/src/main/java/it/unitn/disi/prog2/aliprandi/myproject/JavaFX/Images/torch.jpeg";
            } else if (c == 'W') {
                path = "file:/Users/paoloaliprandi/NetBeansProjects/myProject/src/main/java/it/unitn/disi/prog2/aliprandi/myproject/JavaFX/Images/water.jpeg";
            } else if (c == '⚔') {
                path = "file:/Users/paoloaliprandi/NetBeansProjects/myProject/src/main/java/it/unitn/disi/prog2/aliprandi/myproject/JavaFX/Images/iron_sword.jpeg";
            } else if (c == 'P') {
                path = "file:/Users/paoloaliprandi/NetBeansProjects/myProject/src/main/java/it/unitn/disi/prog2/aliprandi/myproject/JavaFX/Images/stone.png";
            } else if (c == 'D')  {
                path = "file:/Users/paoloaliprandi/NetBeansProjects/myProject/src/main/java/it/unitn/disi/prog2/aliprandi/myproject/JavaFX/Images/dirt.jpeg";
            } else if (c==',') {
                path = "file:/Users/paoloaliprandi/NetBeansProjects/myProject/src/main/java/it/unitn/disi/prog2/aliprandi/myproject/JavaFX/Images/gold.jpeg";
            } else if (c=='A') {
                path = "file:/Users/paoloaliprandi/NetBeansProjects/myProject/src/main/java/it/unitn/disi/prog2/aliprandi/myproject/JavaFX/Images/raw_gold.png";
            } else if (c=='C') {
                path = "file:/Users/paoloaliprandi/NetBeansProjects/myProject/src/main/java/it/unitn/disi/prog2/aliprandi/myproject/JavaFX/Images/raw_coal.png";
            } else if (c=='c') {
                path = "file:/Users/paoloaliprandi/NetBeansProjects/myProject/src/main/java/it/unitn/disi/prog2/aliprandi/myproject/JavaFX/Images/coal.png";
            } else {
                path = "file:/Users/paoloaliprandi/NetBeansProjects/myProject/src/main/java/it/unitn/disi/prog2/aliprandi/myproject/JavaFX/Images/air.png";
            }
            img = new Image(path);

        } catch (NullPointerException x)  {
            x.printStackTrace();
        }

        return img;
    }
}
