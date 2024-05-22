/********************************************
* Name:          Mario Ebenhofer
* Date:          21.05. 2024
* HUE:           27
* EX:            05
* Description:   Draw a chess board (with (mostly) working resizing support!)
*********************************************/

import javax.swing.*;
import java.awt.*;

public class EX_27_05_Chess {
   // Settings
   static final int INITIAL_FRAME_SIZE_X = 500;
   static final int INITIAL_FRAME_SIZE_Y = 500;
   static final int BORDER =  20;
   static final int BOARD_SIZE = 8;
   
   static Pad pad;
   
   public static void main(String[] args) {
      /* Screen: */
      GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
      
      /* How can I get screen resolution in java?
         https://stackoverflow.com/questions/3680221/how-can-i-get-screen-resolution-in-java#answer-3680236 */
      int screenWidth = gd.getDisplayMode().getWidth();
      int screenHeight = gd.getDisplayMode().getHeight();
      
      /* Set-up Pad window */
      pad = new Pad("Chess Board");
      JFrame frame = PadUtil.getPadFrame(pad);
      //pad.setPadSize(INITIAL_FRAME_SIZE_X, INITIAL_FRAME_SIZE_Y);
      pad.setPadSize(screenWidth, screenHeight);  // Possible bug in Pad.java: resize only works, if the
                                                  // Pads window is initially created with its maximum size.
      frame.setLocationRelativeTo(null); // center window
      frame.setResizable(true);
      pad.setVisible(true);
      pad.setPadSize(INITIAL_FRAME_SIZE_X, INITIAL_FRAME_SIZE_Y);
      
      /* Draw */
      for (;;) {
         // update screen resolution in case of resize
         int width = pad.getAreaWidth();
         int height = pad.getAreaHeight();
         
         int minFrameDimension = Math.min(width, height);
         
         int fieldWidth = (minFrameDimension / BOARD_SIZE) - ((2 * BORDER) / BOARD_SIZE);
         
         int nextX = BORDER;
         int nextY = BORDER;
         
         boolean black = true;
         
         for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
               pad.setColor(black ? pad.black : pad.white);
               pad.fillRect(nextX, nextY, fieldWidth, fieldWidth);
               
               nextX += fieldWidth;
               
               black = !black;
            }
            black = !black;
            nextX = BORDER;
            nextY += fieldWidth;
         }
         
         PadUtil.sleep(20);
         pad.clear();
         pad.redraw();
      }
   }
}
