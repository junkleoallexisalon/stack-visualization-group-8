/* Description: Swing GUI that visualizes an array-based stack (push, pop, peek, clear, check, random).
   Programmed by: Group 8 BSIT 2ND YEAR CN 48079 CC104
   Last Modified: October 12, 2026
   Version: 1.0
   Acknowledgements: claude for guidance.
   
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

        JPanel buttons = new JPanel(new GridLayout(0, 1, 5, 5));
        JButton pushBtn = new JButton("PUSH");
        JButton popBtn = new JButton("POP");
        JButton peekBtn = new JButton("PEEK");
        JButton clearBtn = new JButton("CLEAR");
        JButton isEmptyBtn = new JButton("IsEmpty");
        JButton randomBtn = new JButton("RANDOM");
        buttons.add(pushBtn);
        buttons.add(popBtn);
        buttons.add(peekBtn);
        buttons.add(clearBtn);
        buttons.add(isEmptyBtn);
        buttons.add(randomBtn);
        JPanel east = new JPanel(new BorderLayout());
        east.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        east.add(buttons, BorderLayout.NORTH);
        add(east, BorderLayout.EAST);

        statusLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        add(statusLabel, BorderLayout.SOUTH);

        pushBtn.addActionListener(e -> doPush());
        inputField.addActionListener(e -> doPush());
        popBtn.addActionListener(e -> doPop());
        peekBtn.addActionListener(e -> doPeek());
        clearBtn.addActionListener(e -> doClear());
        isEmptyBtn.addActionListener(e -> doIsEmpty());
        randomBtn.addActionListener(e -> doRandom());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
     }

     private void doPush() {
        try {
            int value = Integer.parseInt(inputField.getText().trim());
            stack.push(value);
            refresh("PUSHED: " + value + " is now the top.", false);
        } catch (NumberFormatException ex) {
            refresh("INVALID INPUT: Please enter a whole number.", false);
        } catch (IllegalStateException ex) {
            refresh(ex.getMessage(), false);
        }
        inputField.setText("");
        inputField.requestFocus();
    }

    private void doPop() {
        try {
            int removed = stack.pop();
            refresh("POPPED: " + removed + " was removed from the top.", false);
        } catch (IllegalStateException ex) {
            refresh(ex.getMessage(), false);
        }
    }

    private void doPeek() {
        try {
            int topValue = stack.peek();
            refresh("PEEK: The top element is " + topValue + " (not removed).", true);
        } catch (IllegalStateException ex) {
            refresh(ex.getMessage(), false);
        }
    }

    private void doClear() {
        stack.clear();
        refresh("CLEARED: The stack is now empty.", false);
    }

    private void doIsEmpty() {
        if (stack.isEmpty()) {
            refresh("IS EMPTY: Yes, the stack is empty.", false);
        } else {
            refresh("IS EMPTY: No, the stack is not empty. Size = " + stack.size()
                    + " of " + stack.capacity() + (stack.isFull() ? " (FULL)." : "."), false);
        }
    }

    private void doRandom() {
        stack.clear();
        int count = random.nextInt(stack.capacity()) + 1;
        for (int i = 0; i < count; i++) {
            stack.push(random.nextInt(100) + 1); 

           
        }
        refresh("RANDOM: Stack refilled with " + count + " random element(s).", false);
    }


   private void refresh(String message, boolean peeking) {
        highlightPeek = peeking;
        statusLabel.setText(message);
        addToHistory(message);
        stackPanel.repaint();
    }

    private void addToHistory(String message) {
        operationCount++;
        history.addLast(operationCount + ". " + message);
        if (history.size() > 10) {
            history.removeFirst();
        }
        historyArea.setText(String.join("\n", history));
        historyArea.setCaretPosition(historyArea.getDocument().getLength());
    }
