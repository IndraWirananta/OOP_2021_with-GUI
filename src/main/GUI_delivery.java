package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import Items.*;
import Orders.Order;
import Orders.Payment;
import Persons.Customer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUI_delivery extends javax.swing.JFrame {

    ArrayList<Makanan> food;
    ArrayList<Minuman> drink;
    ArrayList<Order> order;
    ArrayList<Payment> payment;
    Order selectedOrder;
    int foodIndex = -1;

    /**
     * Creates new form DaftarPegawai
     */
    public GUI_delivery() throws ClassNotFoundException, SQLException {
        initComponents();
        getDataMakanan();
        getDataMinuman();
        getData();

        jList2.setListData(new String[0]);
        jList1.addListSelectionListener((ListSelectionEvent e) -> {
            if (jList1.getSelectedIndex() != -1) {
                selectedOrder = order.get(jList1.getSelectedIndex());
                ArrayList<String> nama = new ArrayList<>();
                List<Makanan> listMakanan = selectedOrder.getFood();
                List<Minuman> listMinuman = selectedOrder.getDrink();
                foodIndex = -1;

                for (Makanan m : listMakanan) {
                    nama.add(m.getNama());
                    foodIndex = foodIndex + 1;
                }
                for (Minuman m : listMinuman) {
                    nama.add(m.getNama());
                }
                System.out.println(listMakanan);
                System.out.println(listMinuman);
                String[] emp_arr = new String[nama.size()];
                for (int i = 0; i < nama.size(); i++) {
                    emp_arr[i] = nama.get(i);
                }
                jList2.setListData(emp_arr);
                System.out.println(emp_arr);

                jList2.clearSelection();

                jLabel14.setText("Rp. " + String.format("%.0f", selectedOrder.getTotalPrice()));
                jLabel16.setText("Rp. " + String.format("%.0f", selectedOrder.calculateTaxes()));
                jLabel15.setText("Rp. " + String.format("%.0f", selectedOrder.calculateDeliveryCharges()));
                jLabel17.setText("Rp. " + String.format("%.0f", selectedOrder.calculateTotal()));
                jLabel5.setText(selectedOrder.getCustomer().getName());
                jLabel7.setText(selectedOrder.getCustomer().getPhone());
                jLabel6.setText(selectedOrder.getCustomer().getAddress());
                jLabel8.setText(selectedOrder.getStatus());
                SimpleDateFormat dateFormatYouWant = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String sCertDate = dateFormatYouWant.format(payment.get(jList1.getSelectedIndex()).getPaymentDate());
                jLabel30.setText(sCertDate);
                if (selectedOrder.getStatus().equals("Ongoing")) {
                    Ready.setEnabled(true);
                    Cancel.setEnabled(true);
                } else if (selectedOrder.getStatus().equals("Ready to deliver")) {
                    Deliver.setEnabled(true);
                    Cancel.setEnabled(true);
                }
                jLabel21.setText("");
                jLabel23.setText("");
                jLabel25.setText("");
                jLabel24.setText("");
                jLabel27.setText("");

            }
        });

        jList2.addListSelectionListener((ListSelectionEvent e) -> {
            if (jList2.getSelectedIndex() != -1) {
                if (jList2.getSelectedIndex() <= foodIndex) {
                    Makanan selectedFood = selectedOrder.getFood().get(jList2.getSelectedIndex());
                    jLabel21.setText("Porsi     : ");
                    jLabel23.setText(selectedFood.getNama());
                    jLabel25.setText(Integer.toString(selectedFood.getHarga()));
                    jLabel24.setText("Makanan");
                    jLabel27.setText(Integer.toString(selectedFood.getPorsi()));

                } else {
                    Minuman selectedDrink = selectedOrder.getDrink().get(jList2.getSelectedIndex() - foodIndex - 1);
                    jLabel21.setText("Volume    : ");
                    jLabel23.setText(selectedDrink.getNama());
                    jLabel25.setText(Integer.toString(selectedDrink.getHarga()));
                    jLabel24.setText("Minuman");
                    jLabel27.setText(Integer.toString(selectedDrink.getVolume()));

                }

            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Cancel = new javax.swing.JButton();
        Ready = new javax.swing.JButton();
        Deliver = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        Cancel1 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel2.setText("Nama       :");

        jLabel3.setText("Alamat     :");

        jLabel4.setText("Telp         :");

        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        Ready.setText("Ready");
        Ready.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReadyActionPerformed(evt);
            }
        });

        Deliver.setText("Deliver");
        Deliver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeliverActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setText("Item Detail");

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jLabel14.setText(" Rp. 0");

        jLabel15.setText(" Rp. 0");

        jLabel16.setText(" Rp. 0");

        jLabel19.setText("Ongkir          :");

        jLabel17.setText(" Rp. 0");

        jLabel20.setText("Bayar           :");

        jLabel12.setText("Total Harga  :");

        jLabel13.setText("PPN              :");

        jLabel9.setText("Status     :");

        jLabel21.setText("   ");

        jLabel18.setText("Nama           :");

        jLabel22.setText("Harga           :");

        jLabel23.setText(" ");

        jLabel26.setText("Kategori       :");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel10.setText("Order Details");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel11.setText("Order list");

        jLabel28.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel28.setText("Order Items");

        jLabel29.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel29.setText("Order Status");

        Cancel1.setText("<<< back");
        Cancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancel1ActionPerformed(evt);
            }
        });

        jLabel31.setText("Tanggal   :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(165, 165, 165)
                                .addComponent(jLabel28)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(1, 1, 1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(30, 30, 30)
                                .addComponent(Cancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Ready, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Deliver))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(Cancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(Cancel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jLabel28)
                    .addComponent(jLabel11))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel23))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(23, 23, 23)
                            .addComponent(jLabel3)
                            .addGap(19, 19, 19)
                            .addComponent(jLabel4)
                            .addGap(19, 19, 19)
                            .addComponent(jLabel9))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel29)
                    .addComponent(Cancel)
                    .addComponent(Ready)
                    .addComponent(Deliver))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        try {
            setStatus("Cancelled");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_delivery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GUI_delivery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CancelActionPerformed

    private void ReadyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReadyActionPerformed
        try {
            setStatus("Ready to deliver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_delivery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GUI_delivery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ReadyActionPerformed

    private void DeliverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeliverActionPerformed
        try {
            setStatus("En route");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_delivery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GUI_delivery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DeliverActionPerformed

    private void Cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancel1ActionPerformed
        GUI_AdminMenu d = d = new GUI_AdminMenu();
        d.setLocationRelativeTo(null);
        d.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Cancel1ActionPerformed

    public Customer getCustomer(int id) throws ClassNotFoundException, SQLException {

        Customer user = null;
        DBConn db = new DBConn();
        ResultSet rs = db.query("SELECT * FROM user where id = '" + id + "'");
        while (rs.next()) {
            user = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        }
        return user;
    }

    public void setStatus(String status) throws ClassNotFoundException, SQLException {
        DBConn db;

        try {
            db = new DBConn();
            int res = db.queryDML("UPDATE listorder SET status='" + status + "' WHERE id = " + selectedOrder.getId());
            JOptionPane.showMessageDialog(this, "Order updated successfuly");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_user.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GUI_user.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
        } finally {
            getData();
            getDataMakanan();
            getDataMinuman();
        }
    }

    public Order orderParse(String order, int CustomerId, String status, int orderId) throws ClassNotFoundException, SQLException {
        Order newOrder = new Order(orderId, getCustomer(CustomerId));

        ArrayList orderList = new ArrayList<>();

        String s1 = order;
        List<String> myList = new ArrayList<String>(Arrays.asList(s1.split(",")));
        for (String s : myList) {
            String sNew = s.replace("{", "");
            sNew = sNew.replace("}", "");
            List<String> newList = new ArrayList<String>(Arrays.asList(sNew.split(";")));
            String id = newList.get(0);
            String category = newList.get(1);
            if (category.equals("makanan")) {
                for (Makanan m : food) {
                    if (m.getId() == Integer.parseInt(id)) {
                        newOrder.addFood(m);
                    }
                }
            } else if (category.equals("minuman")) {
                for (Minuman d : drink) {
                    if (d.getId() == Integer.parseInt(id)) {
                        newOrder.addDrink(d);
                    }
                }
            }
            System.out.println("test");

        }
        newOrder.info();
        newOrder.setStatus(status);
        return newOrder;
    }

    public void getData() throws ClassNotFoundException, SQLException {
        jLabel5.setText("");
        jLabel6.setText("");
        jLabel7.setText("");
        jLabel14.setText("");
        jLabel16.setText("");
        jLabel15.setText("");
        jLabel17.setText("");
        jLabel5.setText("");
        jLabel7.setText("");
        jLabel6.setText("");
        jLabel8.setText("");
        jLabel21.setText("");
        jLabel23.setText("");
        jLabel25.setText("");
        jLabel24.setText("");
        jLabel27.setText("");
        Ready.setEnabled(false);
        Deliver.setEnabled(false);
        Cancel.setEnabled(false);
        jList2.setListData(new String[0]);

        DBConn db = new DBConn();
        order = new ArrayList<>();
        payment = new ArrayList<>();
        ArrayList<String> nama = new ArrayList<>();
        ResultSet rs = db.query("SELECT * FROM listorder");
        while (rs.next()) {
            order.add(orderParse(rs.getString(3), rs.getInt(2), rs.getString(4), rs.getInt(1)));
            payment.add(new Payment(rs.getInt(1), rs.getString(5), rs.getString(6)));
            nama.add(getCustomer(rs.getInt(2)).getName() + "_" + rs.getInt(1));
        }
        String[] emp_arr = new String[nama.size()];
        for (int i = 0; i < nama.size(); i++) {
            emp_arr[i] = nama.get(i);
        }
        jList1.setListData(emp_arr);
    }

    public void getDataMakanan() throws ClassNotFoundException, SQLException {
        DBConn db = new DBConn();
        food = new ArrayList<>();
        ResultSet rs = db.query("SELECT * FROM makanan");
        while (rs.next()) {
            food.add(new Makanan(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
        }
    }

    public void getDataMinuman() throws ClassNotFoundException, SQLException {
        DBConn db = new DBConn();
        drink = new ArrayList<>();
        ResultSet rs = db.query("SELECT * FROM minuman");
        while (rs.next()) {
            drink.add(new Minuman(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
        }
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Cancel1;
    private javax.swing.JButton Deliver;
    private javax.swing.JButton Ready;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}