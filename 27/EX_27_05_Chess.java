/********************************************
* Name:          Mario Ebenhofer
* Date:          21.05. 2024
* HUE:           27
* EX:            05
* Description:   Draw a chess board (with (mostly) working resizing support!)
*********************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX_27_05_Chess {
   // Settings
   static final int INITIAL_FRAME_SIZE_X = 500;
   static final int INITIAL_FRAME_SIZE_Y = 500;
   static final int BORDER =  20;
   static final int BOARD_SIZE = 8;
   
   static Pad pad;
   static JFrame frame;
   
   public static void main(String[] args) {
      /* Set-up Pad window */
      pad = new Pad("Chess Board");
      frame = PadUtil.getPadFrame(pad);
      
      pad.setPadSize(INITIAL_FRAME_SIZE_X, INITIAL_FRAME_SIZE_Y);
      frame.setResizable(true);
      frame.setLocationRelativeTo(null); // center window
      
      draw(); // draw board once
      
      // redraw board on window resize
      /* Source: Window resize event?
         https://stackoverflow.com/questions/2303305/window-resize-event/2303329#2303329 */
      frame.addComponentListener(
         new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent componentEvent) {
               draw();
            }
         });
   }
   
   // clears the screen, calculates board size and draws it
   private static void draw() {
      pad.clear();
      
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
      pad.redraw();
   }
}
