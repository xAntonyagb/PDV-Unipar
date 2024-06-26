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
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Antony
 */
public class TableDark extends JTable {

    private static final Color DEFAULT_BACKGROUND = new Color(25,35,45);  
    private static final Color TABLE_BORDER = new Color(19,27,35); 
    private static final Color HEADER_BACKGROUND = new Color(22, 31, 40);
    private static final Color HEADER_FOREGROUND = new Color(204, 204, 204);
    private static final Color EVEN_ROW_BACKGROUND = new Color(40, 46, 56);
    private static final Color ODD_ROW_BACKGROUND = new Color(19,27,35);
    private static final Color SELECTED_EVEN_ROW_BACKGROUND = new Color(33, 103, 153);
    private static final Color SELECTED_ODD_ROW_BACKGROUND = new Color(29, 86, 127);
    private static final Color CELL_FOREGROUND = new Color(204, 204, 204);
 
    private TableDarkHeader header;
    private TableDarkCell cell;

    public TableDark() {
        header = new TableDarkHeader();
        cell = new TableDarkCell();
        
        // Header e colunas
        getTableHeader().setDefaultRenderer(header);
        getTableHeader().setPreferredSize(new Dimension(0, 45));
        setDefaultRenderer(Object.class, cell);
        setRowHeight(35);
        
        // Cor e celulas
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        setBackground(DEFAULT_BACKGROUND);
        
        // Seleção individual
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setRowSelectionAllowed(true);
        setColumnSelectionAllowed(false);
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
        panel.setBackground(HEADER_BACKGROUND);
        
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(DEFAULT_BACKGROUND);
        scroll.setBorder(BorderFactory.createLineBorder(TABLE_BORDER ,2));
        scroll.setBackground(DEFAULT_BACKGROUND);
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
