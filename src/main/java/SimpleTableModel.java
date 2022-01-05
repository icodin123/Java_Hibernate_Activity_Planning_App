import models.Task;

import javax.swing.table.AbstractTableModel;
import java.util.Date;
import java.util.Vector;

/**
 * Simple table model implements functionality outlined by Abstract Table
 * Model.
 *
 * @version 1.0
 * @since 1.0
 */
class SimpleTableModel extends AbstractTableModel {

    /*
     * table column names.
     */
    private final String[] m_colNames = {"name", "date", "completed"};

    /*
     * types of data contained in columns.
     */
    private final Class[] m_colTypes = {String.class, Date.class, Boolean.class};

    /*
     * data vector.
     */
    private final Vector m_macDataVector;

    SimpleTableModel(Vector macDataVector) {
        super();
        this.m_macDataVector = macDataVector;
    }

    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public int getRowCount() {
        return m_macDataVector.size();
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Task task = (Task) (m_macDataVector.elementAt(row));

        switch (col) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                task.setCompleted(!task.getCompleted());
                break;
        }
    }

    @Override
    public String getColumnName(int col) {
        return m_colNames[col];
    }

    @Override
    public Class getColumnClass(int col) {
        return m_colTypes[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Task task = (Task) (m_macDataVector.elementAt(row));

        switch (col) {
            case 0:
                return task.getName();
            case 1:
                return task.getDate();
            case 2:
                return task.getCompleted();
        }

        return "";
    }
}