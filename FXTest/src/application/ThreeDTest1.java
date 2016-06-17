package application;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ThreeDTest1 extends Application  {
	private static final double AXIS_LENGTH = 250.0;
	private static final double HYDROGEN_ANGLE = 104.5;
	final Group root = new Group();  
    final Xform world = new Xform(); 
    final Xform axisGroup = new Xform();
    final PerspectiveCamera camera = new PerspectiveCamera(true);  
    final Xform cameraXform = new Xform();  
    final Xform cameraXform2 = new Xform();  
    final Xform cameraXform3 = new Xform();  
    final Xform moleculeGroup = new Xform();
    private static double CAMERA_INITIAL_DISTANCE = -1200;
    private static double CAMERA_X = 0;
    private static double CAMERA_Y = 0;
    private static final double CAMERA_INITIAL_X_ANGLE = 0.0;  
    private static final double CAMERA_INITIAL_Y_ANGLE = 0.0;  
    private static final double CAMERA_NEAR_CLIP = 0.1;  
    private static final double CAMERA_FAR_CLIP = 10000.0;
    Box box[][] = new Box[33][7];
    boolean trans = false;
    private void buildMolecule() {  
    	   
        final PhongMaterial redMaterial = new PhongMaterial();  
        redMaterial.setDiffuseColor(Color.DARKRED);  
        redMaterial.setSpecularColor(Color.RED);  
    
        final PhongMaterial whiteMaterial = new PhongMaterial();  
        whiteMaterial.setDiffuseColor(Color.WHITE);  
        whiteMaterial.setSpecularColor(Color.LIGHTBLUE);  
    
        final PhongMaterial greyMaterial = new PhongMaterial();  
        greyMaterial.setDiffuseColor(Color.DARKGREY);  
        greyMaterial.setSpecularColor(Color.GREY);  
    
        
    
       Xform moleculeXform = new Xform();  
        
       Xform boxXform = new Xform();
       
       for(int i = 0; i < 33; i++){
    	   for(int j = 0; j < 7; j++){
    		   box[i][j] = new Box(20,20,20);
    		   
    		   
    		   box[i][j].setMaterial(redMaterial);
    		   box[i][j].setTranslateX(-25*i+400);
    		   box[i][j].setTranslateY(-25*j+75);
    	   }
       }
       box[1][3].setMaterial(whiteMaterial);
       box[1][4].setMaterial(whiteMaterial);
       box[1][5].setMaterial(whiteMaterial);
       box[2][2].setMaterial(whiteMaterial);
       box[2][3].setMaterial(whiteMaterial);
       box[3][1].setMaterial(whiteMaterial);
       box[3][3].setMaterial(whiteMaterial);
       box[4][2].setMaterial(whiteMaterial);
       box[4][3].setMaterial(whiteMaterial);
       box[5][3].setMaterial(whiteMaterial);
       box[5][4].setMaterial(whiteMaterial);
       box[5][5].setMaterial(whiteMaterial);
       box[7][1].setMaterial(whiteMaterial);
       box[7][2].setMaterial(whiteMaterial);
       box[7][3].setMaterial(whiteMaterial);
       box[7][4].setMaterial(whiteMaterial);
       box[7][5].setMaterial(whiteMaterial);
       box[8][5].setMaterial(whiteMaterial);
       box[9][5].setMaterial(whiteMaterial);
       box[10][5].setMaterial(whiteMaterial);
       box[12][1].setMaterial(whiteMaterial);
       box[12][5].setMaterial(whiteMaterial);
       box[13][1].setMaterial(whiteMaterial);
       box[13][2].setMaterial(whiteMaterial);
       box[13][3].setMaterial(whiteMaterial);
       box[13][4].setMaterial(whiteMaterial);
       box[13][5].setMaterial(whiteMaterial);
       box[14][1].setMaterial(whiteMaterial);
       box[14][5].setMaterial(whiteMaterial);
       box[16][1].setMaterial(whiteMaterial);
       box[16][2].setMaterial(whiteMaterial);
       box[16][3].setMaterial(whiteMaterial);
       box[16][4].setMaterial(whiteMaterial);
       box[16][5].setMaterial(whiteMaterial);
       box[17][1].setMaterial(whiteMaterial);
       box[17][3].setMaterial(whiteMaterial);
       box[17][5].setMaterial(whiteMaterial);
       box[18][1].setMaterial(whiteMaterial);
       box[18][3].setMaterial(whiteMaterial);
       box[18][5].setMaterial(whiteMaterial);
       box[19][1].setMaterial(whiteMaterial);
       box[19][5].setMaterial(whiteMaterial);
       box[21][1].setMaterial(whiteMaterial);
       box[21][2].setMaterial(whiteMaterial);
       box[21][3].setMaterial(whiteMaterial);
       box[21][4].setMaterial(whiteMaterial);
       box[21][5].setMaterial(whiteMaterial);
       box[22][2].setMaterial(whiteMaterial);
       box[23][3].setMaterial(whiteMaterial);
       box[24][4].setMaterial(whiteMaterial);
       box[25][1].setMaterial(whiteMaterial);
       box[25][2].setMaterial(whiteMaterial);
       box[25][3].setMaterial(whiteMaterial);
       box[25][4].setMaterial(whiteMaterial);
       box[25][5].setMaterial(whiteMaterial);
       box[27][2].setMaterial(whiteMaterial);
       box[27][3].setMaterial(whiteMaterial);
       box[27][4].setMaterial(whiteMaterial);
       box[28][1].setMaterial(whiteMaterial);
       box[28][5].setMaterial(whiteMaterial);
       box[29][1].setMaterial(whiteMaterial);
       box[29][5].setMaterial(whiteMaterial);
       box[30][1].setMaterial(whiteMaterial);
       box[30][5].setMaterial(whiteMaterial);
       box[31][2].setMaterial(whiteMaterial);
       box[31][3].setMaterial(whiteMaterial);
       box[31][4].setMaterial(whiteMaterial);
       
       moleculeXform.getChildren().add(boxXform);
       for(int i = 0; i < 33; i++){
    	   for(int j = 0; j < 7; j++){
    		   boxXform.getChildren().add(box[i][j]);
    	   }
       }
       
        
   
       moleculeGroup.getChildren().add(moleculeXform);  
   
       world.getChildren().addAll(moleculeGroup);  
 }
    
    private void buildAxes() {  
        final PhongMaterial redMaterial = new PhongMaterial();  
        redMaterial.setDiffuseColor(Color.DARKRED);  
        redMaterial.setSpecularColor(Color.RED);  
   
        final PhongMaterial greenMaterial = new PhongMaterial();  
        greenMaterial.setDiffuseColor(Color.DARKGREEN);  
        greenMaterial.setSpecularColor(Color.GREEN);  
   
        final PhongMaterial blueMaterial = new PhongMaterial();  
        blueMaterial.setDiffuseColor(Color.DARKBLUE);  
        blueMaterial.setSpecularColor(Color.BLUE);  
   
        final Box xAxis = new Box(AXIS_LENGTH, 1, 1);  
        final Box yAxis = new Box(1, AXIS_LENGTH, 1);  
        final Box zAxis = new Box(1, 1, AXIS_LENGTH);  
          
        xAxis.setMaterial(redMaterial);  
        yAxis.setMaterial(greenMaterial);  
        zAxis.setMaterial(blueMaterial);  
   
        axisGroup.getChildren().addAll(xAxis, yAxis, zAxis);  
        axisGroup.setVisible(true);  
        world.getChildren().addAll(axisGroup);  
    }
    
    private void buildCamera() {  
        root.getChildren().add(cameraXform);  
        cameraXform.getChildren().add(cameraXform2);  
        cameraXform2.getChildren().add(cameraXform3);  
        cameraXform3.getChildren().add(camera);  
        cameraXform3.setRotateZ(180.0);  
   
        camera.setNearClip(CAMERA_NEAR_CLIP);  
        camera.setFarClip(CAMERA_FAR_CLIP);  
        camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);  
        cameraXform.ry.setAngle(CAMERA_INITIAL_Y_ANGLE);  
        cameraXform.rx.setAngle(CAMERA_INITIAL_X_ANGLE);  
    }
    
    private static final double CONTROL_MULTIPLIER = 0.1;      
    private static final double SHIFT_MULTIPLIER = 10.0;      
    private static final double MOUSE_SPEED = 0.1;      
    private static final double ROTATION_SPEED = 2.0;     
    private static final double TRACK_SPEED = 0.3;  
    double mousePosX;  
    double mousePosY;  
    double mouseOldX;  
    double mouseOldY;  
    double mouseDeltaX;  
    double mouseDeltaY;
    
    private void handleMouse(Scene scene, final Node root) {  
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {  
            @Override  
            public void handle(MouseEvent me) {  
                mousePosX = me.getSceneX();  
                mousePosY = me.getSceneY();  
                mouseOldX = me.getSceneX();  
                mouseOldY = me.getSceneY();  
            }  
        });  
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {  
            @Override  
            public void handle(MouseEvent me) {  
                mouseOldX = mousePosX;  
                mouseOldY = mousePosY;  
                mousePosX = me.getSceneX();  
                mousePosY = me.getSceneY();  
                mouseDeltaX = (mousePosX - mouseOldX);  
                mouseDeltaY = (mousePosY - mouseOldY);  
  
                double modifier = 1.0;  
  
                if (me.isControlDown()) {  
                    modifier = CONTROL_MULTIPLIER;  
                }  
                if (me.isShiftDown()) {  
                    modifier = SHIFT_MULTIPLIER;  
                }  
                if (me.isPrimaryButtonDown()) {  
                    cameraXform.ry.setAngle(cameraXform.ry.getAngle()  
                            - mouseDeltaX * MOUSE_SPEED * modifier  
                            * ROTATION_SPEED);  
                    cameraXform.rx.setAngle(cameraXform.rx.getAngle()  
                            + mouseDeltaY * MOUSE_SPEED * modifier  
                            * ROTATION_SPEED);  
                } else if (me.isSecondaryButtonDown()) {  
                    double z = camera.getTranslateZ();  
                    double newZ = z + mouseDeltaX * MOUSE_SPEED * modifier;  
                    camera.setTranslateZ(newZ);  
                } else if (me.isMiddleButtonDown()) {  
                    cameraXform2.t.setX(cameraXform2.t.getX() + mouseDeltaX  
                            * MOUSE_SPEED * modifier * TRACK_SPEED);  
                    cameraXform2.t.setY(cameraXform2.t.getY() + mouseDeltaY  
                            * MOUSE_SPEED * modifier * TRACK_SPEED);  
                }  
            }  
        });  
    }  
  
    private void handleKeyboard(Scene scene, final Node root) {  
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {  
            @Override  
            public void handle(KeyEvent event) {  
                switch (event.getCode()) {  
                case E:  
                	CAMERA_INITIAL_DISTANCE+=100; 
                    camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);  
                     
                    break;  
                case Q:  
                	CAMERA_INITIAL_DISTANCE-=100; 
                    camera.setTranslateZ(CAMERA_INITIAL_DISTANCE); 
                    break;  
                case A:  
                	CAMERA_X+=10;
                	cameraXform2.t.setX(CAMERA_X);  
                      
                    break; 
                case D:  
                	CAMERA_X-=10;
                	cameraXform2.t.setX(CAMERA_X);  
                      
                    break;  
                case W:  
                	CAMERA_Y+=10;
                	cameraXform2.t.setY(CAMERA_Y);  
                      
                    break;  
                case S:  
                	CAMERA_Y-=10;
                	cameraXform2.t.setY(CAMERA_Y);  
                      
                    break;  
                case R:  
                	CAMERA_INITIAL_DISTANCE=-1200;
                	CAMERA_X=0;
                	CAMERA_Y=0;
                    cameraXform2.t.setX(CAMERA_X);  
                    cameraXform2.t.setY(CAMERA_Y);  
                    camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);  
                    cameraXform.ry.setAngle(CAMERA_INITIAL_Y_ANGLE);  
                    cameraXform.rx.setAngle(CAMERA_INITIAL_X_ANGLE);  
                    break;
                case T:
                	if(!trans){
                	Timeline timeline = new Timeline();  
                	for(int i = 1; i < 7; i++){
                		for(int j = 1; j < 6; j++){
                			timeline.getKeyFrames().addAll(  
                        	        new KeyFrame(Duration.ZERO, // set start position at 0  
                        	            new KeyValue(box[i][j].translateXProperty(), box[i][j].getTranslateX()),  
                        	            new KeyValue(box[i][j].translateYProperty(), box[i][j].getTranslateY())  
                        	        ),  
                        	        new KeyFrame(new Duration(1000), // set end position at 40s  
                        	            new KeyValue(box[i][j].translateXProperty(), box[i][j].getTranslateX()- 100),  
                        	            new KeyValue(box[i][j].translateYProperty(), box[i][j].getTranslateY())  
                        	        )  
                			);
                		}
                	}
                	for(int j = 1; j < 6; j++){
            			timeline.getKeyFrames().addAll(  
                    	        new KeyFrame(Duration.ZERO, // set start position at 0  
                    	            new KeyValue(box[7][j].translateXProperty(), box[7][j].getTranslateX())  
                    	        ),  
                    	        new KeyFrame(new Duration(1000), // set end position at 40s  
                    	            new KeyValue(box[7][j].translateXProperty(), box[7][j].getTranslateX()+ 100)
                    	        )  
            			);
            		}
                	for(int j = 1; j < 6; j++){
                		timeline.getKeyFrames().addAll(  
                	        new KeyFrame(Duration.ZERO, // set start position at 0  
                	            new KeyValue(box[8][j].translateXProperty(), box[8][j].getTranslateX())  
                	        ),  
                	        new KeyFrame(new Duration(1000), // set end position at 40s  
                	            new KeyValue(box[8][j].translateXProperty(), box[8][j].getTranslateX()+ 150)  
                	        )  
                				);
                	}
                	for(int j = 1; j < 4; j++){
                		timeline.getKeyFrames().addAll(  
                	        new KeyFrame(Duration.ZERO, // set start position at 0  
                	            new KeyValue(box[9][j].translateXProperty(), box[9][j].getTranslateX())  
                	        ),  
                	        new KeyFrame(new Duration(1000), // set end position at 40s  
                	            new KeyValue(box[9][j].translateXProperty(), box[9][j].getTranslateX()+ 200)  
                	        )  
                		);
                	}
                	for(int j = 1; j < 5; j++){
                		timeline.getKeyFrames().addAll(  
                	        new KeyFrame(Duration.ZERO, // set start position at 0  
                	            new KeyValue(box[10][j].translateXProperty(), box[10][j].getTranslateX())  
                	        ),  
                	        new KeyFrame(new Duration(1000), // set end position at 40s  
                	            new KeyValue(box[10][j].translateXProperty(), box[10][j].getTranslateX()+ 150)  
                	        )  
                		);
                	}
                	timeline.getKeyFrames().addAll(  
                	        new KeyFrame(Duration.ZERO, // set start position at 0  
                	            new KeyValue(box[9][4].translateXProperty(), box[9][4].getTranslateX()),  
                	            new KeyValue(box[9][4].translateYProperty(), box[9][4].getTranslateY()),
                	            new KeyValue(box[9][5].translateXProperty(), box[9][5].getTranslateX()),
                	            new KeyValue(box[9][5].translateYProperty(), box[9][5].getTranslateY()),
                	            new KeyValue(box[10][5].translateXProperty(), box[10][5].getTranslateX()),
                	            new KeyValue(box[10][5].translateYProperty(), box[10][5].getTranslateY()),
                	            new KeyValue(box[28][1].translateXProperty(), box[28][1].getTranslateX()),
                	            new KeyValue(box[28][1].translateYProperty(), box[28][1].getTranslateY()),
                	            new KeyValue(box[28][5].translateXProperty(), box[28][5].getTranslateX()),
                	            new KeyValue(box[28][5].translateYProperty(), box[28][5].getTranslateY()),
                	            new KeyValue(box[29][1].translateXProperty(), box[29][1].getTranslateX()),
                	            new KeyValue(box[29][1].translateYProperty(), box[29][1].getTranslateY()),
                	            new KeyValue(box[29][5].translateXProperty(), box[29][5].getTranslateX()),
                	            new KeyValue(box[29][5].translateYProperty(), box[29][5].getTranslateY()),
                	            new KeyValue(box[30][1].translateXProperty(), box[30][1].getTranslateX()),
                	            new KeyValue(box[30][1].translateYProperty(), box[30][1].getTranslateY()),
                	            new KeyValue(box[30][2].translateXProperty(), box[30][2].getTranslateX()),
                	            new KeyValue(box[30][2].translateYProperty(), box[30][2].getTranslateY()),
                	            new KeyValue(box[30][3].translateXProperty(), box[30][3].getTranslateX()),
                	            new KeyValue(box[30][3].translateYProperty(), box[30][3].getTranslateY()),
                	            new KeyValue(box[30][4].translateXProperty(), box[30][4].getTranslateX()),
                	            new KeyValue(box[30][4].translateYProperty(), box[30][4].getTranslateY()),
                	            new KeyValue(box[30][5].translateXProperty(), box[30][5].getTranslateX()),
                	            new KeyValue(box[30][5].translateYProperty(), box[30][5].getTranslateY()),
                	            new KeyValue(box[29][3].translateXProperty(), box[29][5].getTranslateX()),
                	            new KeyValue(box[29][3].translateYProperty(), box[29][5].getTranslateY()),
                	            new KeyValue(box[26][1].translateXProperty(), box[26][1].getTranslateX()),
                	            new KeyValue(box[26][1].translateYProperty(), box[26][1].getTranslateY()),
                	            new KeyValue(box[26][3].translateXProperty(), box[26][3].getTranslateX()),
                	            new KeyValue(box[26][3].translateYProperty(), box[26][3].getTranslateY()),
                	            new KeyValue(box[26][4].translateXProperty(), box[26][4].getTranslateX()),
                	            new KeyValue(box[26][4].translateYProperty(), box[26][4].getTranslateY()),
                	            new KeyValue(box[26][5].translateXProperty(), box[26][5].getTranslateX()),
                	            new KeyValue(box[26][5].translateYProperty(), box[26][5].getTranslateY()),
                	            new KeyValue(box[27][1].translateXProperty(), box[27][1].getTranslateX()),
                	            new KeyValue(box[27][1].translateYProperty(), box[27][1].getTranslateY()),
                	            new KeyValue(box[27][5].translateXProperty(), box[27][5].getTranslateX()),
                	            new KeyValue(box[27][5].translateYProperty(), box[27][5].getTranslateY()),
                	            new KeyValue(box[28][2].translateXProperty(), box[28][2].getTranslateX()),
                	            new KeyValue(box[28][2].translateYProperty(), box[28][2].getTranslateY()),
                	            new KeyValue(box[28][3].translateXProperty(), box[28][3].getTranslateX()),
                	            new KeyValue(box[28][3].translateYProperty(), box[28][3].getTranslateY()),
                	            new KeyValue(box[26][2].translateXProperty(), box[26][2].getTranslateX()),
                	            new KeyValue(box[26][2].translateYProperty(), box[26][2].getTranslateY()),
                	            new KeyValue(box[28][4].translateXProperty(), box[28][4].getTranslateX()),
                	            new KeyValue(box[28][4].translateYProperty(), box[28][4].getTranslateY()),
                	            new KeyValue(box[29][2].translateXProperty(), box[29][2].getTranslateX()),
                	            new KeyValue(box[29][2].translateYProperty(), box[29][2].getTranslateY()),
                	            new KeyValue(box[29][4].translateXProperty(), box[29][4].getTranslateX()),
                	            new KeyValue(box[29][4].translateYProperty(), box[29][4].getTranslateY())
                	          
                	        ),  
                	        new KeyFrame(new Duration(1000), // set end position at 40s  
                	            new KeyValue(box[9][4].translateXProperty(), box[9][4].getTranslateX()+ 200),  
                	            new KeyValue(box[9][4].translateYProperty(), box[9][4].getTranslateY()- 25),
                	            new KeyValue(box[9][5].translateXProperty(), box[9][5].getTranslateX()+ 200),
                	            new KeyValue(box[9][5].translateYProperty(), box[9][5].getTranslateY()+25),
                	            new KeyValue(box[10][5].translateXProperty(), box[10][5].getTranslateX()-75),
                	            new KeyValue(box[10][5].translateYProperty(), box[10][5].getTranslateY()+50),
                	            new KeyValue(box[28][1].translateXProperty(), box[28][1].getTranslateX()+425),
                	            new KeyValue(box[28][1].translateYProperty(), box[28][1].getTranslateY()),
                	            new KeyValue(box[28][5].translateXProperty(), box[28][5].getTranslateX()+425),
                	            new KeyValue(box[28][5].translateYProperty(), box[28][5].getTranslateY()),
                	            new KeyValue(box[29][1].translateXProperty(), box[29][1].getTranslateX()+425),
                	            new KeyValue(box[29][1].translateYProperty(), box[29][1].getTranslateY()-25),
                	            new KeyValue(box[29][5].translateXProperty(), box[29][5].getTranslateX()+375),
                	            new KeyValue(box[29][5].translateYProperty(), box[29][5].getTranslateY()+25),
                	            new KeyValue(box[30][1].translateXProperty(), box[30][1].getTranslateX()+375),
                	            new KeyValue(box[30][1].translateYProperty(), box[30][1].getTranslateY()),
                	            new KeyValue(box[30][2].translateXProperty(), box[30][2].getTranslateX()-25),
                	            new KeyValue(box[30][2].translateYProperty(), box[30][2].getTranslateY()),
                	            new KeyValue(box[30][3].translateXProperty(), box[30][3].getTranslateX()-25),
                	            new KeyValue(box[30][3].translateYProperty(), box[30][3].getTranslateY()),
                	            new KeyValue(box[30][4].translateXProperty(), box[30][4].getTranslateX()-25),
                	            new KeyValue(box[30][4].translateYProperty(), box[30][4].getTranslateY()),
                	            new KeyValue(box[30][5].translateXProperty(), box[30][5].getTranslateX()+375),
                	            new KeyValue(box[30][5].translateYProperty(), box[30][5].getTranslateY()),
                	            new KeyValue(box[29][3].translateXProperty(), box[29][3].getTranslateX()+625),
                	            new KeyValue(box[29][3].translateYProperty(), box[29][3].getTranslateY()-50),
                	            new KeyValue(box[26][1].translateXProperty(), box[26][1].getTranslateX()+350),
                	            new KeyValue(box[26][1].translateYProperty(), box[26][1].getTranslateY()),
                	            new KeyValue(box[26][3].translateXProperty(), box[26][3].getTranslateX()+350),
                	            new KeyValue(box[26][3].translateYProperty(), box[26][3].getTranslateY()),
                	            new KeyValue(box[26][4].translateXProperty(), box[26][4].getTranslateX()+350),
                	            new KeyValue(box[26][4].translateYProperty(), box[26][4].getTranslateY()),
                	            new KeyValue(box[26][5].translateXProperty(), box[26][5].getTranslateX()+350),
                	            new KeyValue(box[26][5].translateYProperty(), box[26][5].getTranslateY()),
                	            new KeyValue(box[27][1].translateXProperty(), box[27][1].getTranslateX()+350),
                	            new KeyValue(box[27][1].translateYProperty(), box[27][1].getTranslateY()),
                	            new KeyValue(box[27][5].translateXProperty(), box[27][5].getTranslateX()+350),
                	            new KeyValue(box[27][5].translateYProperty(), box[27][5].getTranslateY()),
                	            new KeyValue(box[28][2].translateXProperty(), box[28][2].getTranslateX()+350),
                	            new KeyValue(box[28][2].translateYProperty(), box[28][2].getTranslateY()),
                	            new KeyValue(box[28][3].translateXProperty(), box[28][3].getTranslateX()+350),
                	            new KeyValue(box[28][3].translateYProperty(), box[28][3].getTranslateY()),
                	            new KeyValue(box[26][2].translateXProperty(), box[26][2].getTranslateX()+325),
                	            new KeyValue(box[26][2].translateYProperty(), box[26][2].getTranslateY()),
                	            new KeyValue(box[28][4].translateXProperty(), box[28][4].getTranslateX()+375),
                	            new KeyValue(box[28][4].translateYProperty(), box[28][4].getTranslateY()),
                	            new KeyValue(box[29][2].translateXProperty(), box[29][2].getTranslateX()+375),
                	            new KeyValue(box[29][2].translateYProperty(), box[29][2].getTranslateY()+25),
                	            new KeyValue(box[29][4].translateXProperty(), box[29][4].getTranslateX()+375),
                	            new KeyValue(box[29][4].translateYProperty(), box[29][4].getTranslateY()-25)
                	        )  
                		);
                	
                	for(int i = 11; i < 15; i++){
                		for(int j = 1; j < 6; j++){
                			timeline.getKeyFrames().addAll(  
                        	        new KeyFrame(Duration.ZERO, // set start position at 0  
                        	            new KeyValue(box[i][j].translateXProperty(), box[i][j].getTranslateX())  
                        	        ),  
                        	        new KeyFrame(new Duration(1000), // set end position at 40s  
                        	            new KeyValue(box[i][j].translateXProperty(), box[i][j].getTranslateX()- 125)  
                        	        )  
                			);
                		}
                	}
                	for(int i = 15; i < 20; i++){
                		for(int j = 1; j < 6; j++){
                			timeline.getKeyFrames().addAll(  
                        	        new KeyFrame(Duration.ZERO, // set start position at 0  
                        	            new KeyValue(box[i][j].translateXProperty(), box[i][j].getTranslateX())  
                        	        ),  
                        	        new KeyFrame(new Duration(1000), // set end position at 40s  
                        	            new KeyValue(box[i][j].translateXProperty(), box[i][j].getTranslateX()- 275)  
                        	        )  
                			);
                		}
                	}
                	for(int j = 1; j < 6; j++){
            			timeline.getKeyFrames().addAll(  
                    	        new KeyFrame(Duration.ZERO, // set start position at 0  
                    	            new KeyValue(box[26][j].translateXProperty(), box[26][j].getTranslateX())  
                    	        ),  
                    	        new KeyFrame(new Duration(1000), // set end position at 40s  
                    	            new KeyValue(box[26][j].translateXProperty(), box[26][j].getTranslateX()+400)  
                    	        )  
            			);
            		}
                	for(int j = 2; j < 5; j++){
            			timeline.getKeyFrames().addAll(  
                    	        new KeyFrame(Duration.ZERO, // set start position at 0  
                    	            new KeyValue(box[27][j].translateXProperty(), box[27][j].getTranslateX()),
                    	            new KeyValue(box[31][j].translateXProperty(), box[31][j].getTranslateX())
                    	        ),  
                    	        new KeyFrame(new Duration(1000), // set end position at 40s  
                    	            new KeyValue(box[27][j].translateXProperty(), box[27][j].getTranslateX()+400),
                    	            new KeyValue(box[31][j].translateXProperty(), box[31][j].getTranslateX()+400)
                    	        )  
            			);
            		}
                	timeline.play();
                	trans = true;
                	}
                	
                	
                	break;
                }
                
            }  
        });  
    }
    
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Scene scene = new Scene(root, 1024, 768, true);  
        scene.setFill(Color.GREY);  
   
        primaryStage.setTitle("Molecule Sample Application");  
        primaryStage.setScene(scene);  
        primaryStage.show();
        root.getChildren().add(world);  
        buildCamera();  
        buildAxes();
        buildMolecule();
        handleMouse(scene, root);
        handleKeyboard(scene, root);
        axisGroup.setVisible(false);
        scene.setCamera(camera);
	}
	public static void main(String[] args) {  
        launch(args);  
    }
}
