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

     public StackVisualizer() {
        super("2D Stack Visualizer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel inputRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputRow.add(new JLabel("Value:"));
        inputRow.add(inputField);
        add(inputRow, BorderLayout.NORTH);

        add(stackPanel, BorderLayout.CENTER);

        historyArea.setEditable(false);
        historyArea.setLineWrap(true);
        historyArea.setWrapStyleWord(true);
        JScrollPane historyScroll = new JScrollPane(historyArea);
        historyScroll.setBorder(BorderFactory.createTitledBorder("History (last 10)"));
        add(historyScroll, BorderLayout.WEST);
