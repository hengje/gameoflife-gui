package no.finntech.kata.gameoflife.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Gui {

    private final GameOfLife gameOfLife;
    private volatile boolean [][] currentBoard;

    private JButton b;
    private JTextField t;

    public static void main(String[] args) throws InterruptedException {
        Gui gui = new Gui(new GameOfLifeRandomImpl(), new boolean[50][50]);
        gui.display();
    }

    public Gui(final GameOfLife gameOfLife, final boolean[][] initialBoard) {
        this.gameOfLife = gameOfLife;
        this.gameOfLife.init(initialBoard);
        this.currentBoard = initialBoard;
    }

    public void display() throws InterruptedException {

        JFrame myWindow = new JFrame("This is my window");

        //myWindow.setSize(800, 800);
        //myWindow.getContentPane().setLayout(new BorderLayout());
        myWindow.getContentPane().setLayout(new FlowLayout());

        b = new JButton("Load");
        t = new JTextField(60);
        myWindow.getContentPane().add(b);
        myWindow.getContentPane().add(t);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText ("Game of life");
            }
        });

        //GameOfLife model = new GameOfLife(5);
        GameOfLifeTableModel model = new GameOfLifeTableModel();
        //GameOfLife model = new GameOfLife("/Users/javalons/Documents/GameOfLife/Glider.lif.txt");
        JTable table = new JTable(model);

        table.setDefaultRenderer(Integer.class, new CellRenderer());
        table.setShowGrid(true);
        table.setGridColor(Color.black);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setMaxWidth(5);
        }

        myWindow.getContentPane().add(table);

        myWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myWindow.pack();
        myWindow.setVisible(true);

        do {
            Thread.sleep(50);
            currentBoard = gameOfLife.nextGeneration();
            table.updateUI();
        } while (true);
    }

    private class GameOfLifeTableModel implements TableModel {

        public int getRowCount() {
            return currentBoard.length;
        }

        public int getColumnCount() {
            return currentBoard[0].length;
        }

        public String getColumnName(int columnIndex) {
            return "";
        }

        public Class<?> getColumnClass(int columnIndex) {
            return Integer.class;
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            return currentBoard[rowIndex][columnIndex] ? 1 : 0;
        }

        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            throw new NotImplementedException();
        }

        public void addTableModelListener(TableModelListener l) {
        }

        public void removeTableModelListener(TableModelListener l) {
        }
    }

    private static class CellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            //setOpaque(true);
            if (table.getValueAt(row, column).equals(1)) {
                setBackground(Color.green);
                setForeground(Color.green);
            } else {
                setBackground(Color.white);
                setForeground(Color.white);
            }

            return this;
        }
    }

}
