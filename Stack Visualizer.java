/* Description: Swing GUI that visualizes an array-based stack (push, pop, peek, clear, check, random).
   Programmed by: <your name> <course> <cn> <subject>
   Last Modified: October 12, 2026
   Version: 1.0
   Acknowledgements: <list sites / generative AI used and the prompt>
*/
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class StackVisualizer extends JFrame {

    private final ArrayStack stack = new ArrayStack();
    private final Random random = new Random();

    private final JTextField inputField = new JTextField(8);
    private final JLabel statusLabel = new JLabel("Welcome! Enter a number and press PUSH.");
    private final StackPanel stackPanel = new StackPanel();
    private boolean highlightPeek = false;
  private final LinkedList<String> history = new LinkedList<>();
    private final JTextArea historyArea = new JTextArea(12, 22);
    private int operationCount = 0;
}
