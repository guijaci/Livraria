package livrarianavegador;

import daolivraria.*;

public class JanelaTabela extends javax.swing.JFrame {

    javax.swing.table.DefaultTableModel tModel;
    
    public JanelaTabela(LivroTO livro) {
        tModel = new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"ID", Integer.toString(livro.getLivro_id())},
                {"Título", livro.getTitulo()},
                {"Autor", livro.getAutor()},
                {"Editora", livro.getEditora()},
                {"Ano", Integer.toString(livro.getAno())},
                {"Genero", livro.getGenero()},
                {"Preço", String.format("R$ %.2f", livro.getPreco())},
                {"Quantidade", Integer.toString(livro.getEstoque())},
                {"Reserva", Integer.toString(livro.getReserva())},
                {"Descrição", livro.getDescricao()}
            },
            new String [] {
                "Atributos", "Livros"
            }
        );
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(tModel);
        jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
