package com.mycompany.app.pdv.views.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Antony
 */
public class TableDark extends JTable {

    private static final Color HEADER_BACKGROUND = new Color(22, 31, 40);
    private static final Color HEADER_FOREGROUND = new Color(204, 204, 204);
    private static final Color EVEN_ROW_BACKGROUND = new Color(40, 46, 56);
    private static final Color ODD_ROW_BACKGROUND = new Color(22, 31, 40);
    private static final Color SELECTED_EVEN_ROW_BACKGROUND = new Color(33, 103, 153);
    private static final Color SELECTED_ODD_ROW_BACKGROUND = new Color(29, 86, 127);
    private static final Color CELL_FOREGROUND = new Color(204, 204, 204);
    private static final Color SCROLL_BACKGROUND = new Color(22, 31, 40);
    private static final Color SCROLL_BORDER_COLOR = new Color(40, 46, 56);

    private TableDarkHeader header;
    private TableDarkCell cell;

    public TableDark() {
        header = new TableDarkHeader();
        cell = new TableDarkCell();
        getTableHeader().setDefaultRenderer(header);
        getTableHeader().setPreferredSize(new Dimension(0, 35));
        setDefaultRenderer(Object.class, cell);
        setRowHeight(30);
        setShowGrid(false); // Remove grid lines
        setIntercellSpacing(new Dimension(0, 0)); // Remove spacing between cells
        setBackground(SCROLL_BACKGROUND); // Set table background color
    }

    public void setColumnAlignment(int column, int align) {
        header.setAlignment(column, align);
    }

    public void setCellAlignment(int column, int align) {
        cell.setAlignment(column, align);
    }

    public void setColumnWidth(int column, int width) {
        getColumnModel().getColumn(column).setPreferredWidth(width);
        getColumnModel().getColumn(column).setMinWidth(width);
        getColumnModel().getColumn(column).setMaxWidth(width);
        getColumnModel().getColumn(column).setMinWidth(10);
        getColumnModel().getColumn(column).setMaxWidth(10000);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel panel = new JPanel();
        panel.setBackground(SCROLL_BACKGROUND);
        panel.setForeground(SCROLL_BACKGROUND);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(SCROLL_BACKGROUND);
        scroll.setBorder(BorderFactory.createLineBorder(SCROLL_BORDER_COLOR, 2));
    }

    private class TableDarkHeader extends DefaultTableCellRenderer {

        private Map<Integer, Integer> alignment = new HashMap<>();

        public void setAlignment(int column, int align) {
            alignment.put(column, align);
        }

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
            Component com = super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            com.setBackground(HEADER_BACKGROUND);
            com.setForeground(HEADER_FOREGROUND);
            com.setFont(com.getFont().deriveFont(Font.BOLD, 12));
            if (alignment.containsKey(i1)) {
                setHorizontalAlignment(alignment.get(i1));
            } else {
                setHorizontalAlignment(JLabel.LEFT);
            }
            return com;
        }
    }

    private class TableDarkCell extends DefaultTableCellRenderer {

        private Map<Integer, Integer> alignment = new HashMap<>();

        public void setAlignment(int column, int align) {
            alignment.put(column, align);
        }

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int row, int column) {
            Component com = super.getTableCellRendererComponent(jtable, o, bln, bln1, row, column);
            if (isCellSelected(row, column)) {
                if (row % 2 == 0) {
                    com.setBackground(SELECTED_EVEN_ROW_BACKGROUND);
                } else {
                    com.setBackground(SELECTED_ODD_ROW_BACKGROUND);
                }
            } else {
                if (row % 2 == 0) {
                    com.setBackground(EVEN_ROW_BACKGROUND);
                } else {
                    com.setBackground(ODD_ROW_BACKGROUND);
                }
            }
            com.setForeground(CELL_FOREGROUND);
            setBorder(new EmptyBorder(0, 6, 0, 6));
            if (alignment.containsKey(column)) {
                setHorizontalAlignment(alignment.get(column));
            } else {
                setHorizontalAlignment(JLabel.LEFT);
            }
            return com;
        }
    }
}
