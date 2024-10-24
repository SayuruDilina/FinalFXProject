package edu.icet.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.icet.bo.BoFactory;
import edu.icet.bo.custom.ProductsBo;
import edu.icet.bo.custom.SuppliersBo;
import edu.icet.dto.Products;
import edu.icet.dto.Suppliers;
import edu.icet.entity.ProductsEntity;
import edu.icet.entity.SuppliersEntity;
import edu.icet.util.BoType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class UserDashBoardController implements Initializable {


    private  AnchorPane loadPage;

    @FXML
    private JFXComboBox<String> cmbCategory;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCategory;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colISupplierID;

    @FXML
    private TableColumn<?, ?> colISupplierName;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colItemName;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colProduct;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colSize;

    @FXML
    private AnchorPane productsPage;

    @FXML
    private AnchorPane suppliersPage;

    @FXML
    private TableView<ProductsEntity> tblProductView;

    @FXML
    private TableView<SuppliersEntity> tblSupplierView;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtItemCode;

    @FXML
    private JFXTextField txtItemName;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private JFXTextField txtProductName;

    @FXML
    private JFXTextField txtQuantity;

    @FXML
    private JFXTextField txtSize;

    @FXML
    private JFXTextField txtSupplierName;

    @FXML
    private JFXTextField txtSupplierId;



    @FXML
    void btnAddProductOnAction(ActionEvent event) {
        Products products=new Products(Integer.parseInt(txtItemCode.getText()),
                txtItemName.getText(),
                txtSize.getText(),
                Integer.parseInt(txtQuantity.getText()),
                Double.parseDouble(txtPrice.getText()),
                cmbCategory.getValue());

        ProductsBo productsBo=BoFactory.getInstance().getBoType(BoType.PRODUCTS);
        productsBo.addProducts(products);
        loadTable();


    }

    @FXML
    void btnUpdateProductOnAction(ActionEvent event) {
        Products products=new Products(Integer.parseInt(txtItemCode.getText()),
                txtItemName.getText(),
                txtSize.getText(),
                Integer.parseInt(txtQuantity.getText()),
                Double.parseDouble(txtPrice.getText()),
                cmbCategory.getValue());

        ProductsBo productsBo=BoFactory.getInstance().getBoType(BoType.PRODUCTS);
        productsBo.updateProducts(products);
        loadTable();

    }

    @FXML
    void btnDeleteProductOnAction(ActionEvent event) {
        Products products=new Products(Integer.parseInt(txtItemCode.getText()),
                txtItemName.getText(),
                txtSize.getText(),
                Integer.parseInt(txtQuantity.getText()),
                Double.parseDouble(txtPrice.getText()),
                cmbCategory.getValue());

        ProductsBo productsBo=BoFactory.getInstance().getBoType(BoType.PRODUCTS);
        productsBo.deleteProducts(products);
        loadTable();
    }
    @FXML
    void btnAddSupplierOnAction(ActionEvent event) {
        Suppliers suppliers=new Suppliers(Integer.parseInt(
                txtSupplierId.getText()),
                txtSupplierName.getText(),
                txtContact.getText(),
                txtAddress.getText(),
                txtProductName.getText()
                );

        SuppliersBo suppliersBo=BoFactory.getInstance().getBoType(BoType.SUPPLIERS);
        suppliersBo.addSupplier(suppliers);
        loadSupplierTable();
    }

    @FXML
    void btnUpdateSupplierOnAction(ActionEvent event) {
        Suppliers suppliers=new Suppliers(Integer.parseInt(
                txtSupplierId.getText()),
                txtSupplierName.getText(),
                txtContact.getText(),
                txtAddress.getText(),
                txtProductName.getText()
        );

        SuppliersBo suppliersBo=BoFactory.getInstance().getBoType(BoType.SUPPLIERS);
        suppliersBo.updateSupplier(suppliers);
        loadSupplierTable();
    }
    @FXML
    void btnDeleteSupplierOnAction(ActionEvent event) {

        Suppliers suppliers=new Suppliers(Integer.parseInt(
                txtSupplierId.getText()),
                txtSupplierName.getText(),
                txtContact.getText(),
                txtAddress.getText(),
                txtProductName.getText()
        );

        SuppliersBo suppliersBo=BoFactory.getInstance().getBoType(BoType.SUPPLIERS);
        suppliersBo.deleteSuppliers(suppliers);
        loadSupplierTable();
    }

    @FXML
    void btnDashBoardOnAction(ActionEvent event) {

    }



    @FXML
    void btnMangeEmployeeOnAction(ActionEvent event) {

    }

    @FXML
    void btnOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnProductsPageOnAction(ActionEvent event) {
            loadPage.setVisible(false);
            loadPage=productsPage;
            loadPage.setVisible(true);
            loadTable();



    }

    private void loadTable() {
        ProductsBo productsBo= BoFactory.getInstance().getBoType(BoType.PRODUCTS);


        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        tblProductView.setItems(productsBo.getAll());
    }


    @FXML
    void btnSuppliersPageOnAction(ActionEvent event) {
            loadPage.setVisible(false);
            loadPage=suppliersPage;
            loadPage.setVisible(true);
            loadSupplierTable();

    }

    private void loadSupplierTable() {
        SuppliersBo suppliersBo=BoFactory.getInstance().getBoType(BoType.SUPPLIERS);
        colISupplierID.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        colISupplierName.setCellValueFactory(new PropertyValueFactory<>("suppliersName"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("suppliersContact"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("suppliersAddress"));
        colProduct.setCellValueFactory(new PropertyValueFactory<>("suppliersProductName"));
        tblSupplierView.setItems(suppliersBo.getAll());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadPage=productsPage;
        loadPage.setVisible(true);

        ObservableList<String> category= FXCollections.observableArrayList();
        category.add("Gents");
        category.add("Ladies");
        category.add("Kids");
        cmbCategory.setItems(category);

        tblProductView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if(newValue!=null){
                setTextToValues(newValue);
            }
        });
        tblSupplierView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if(newValue!=null){
                setTextToSuppliersValue(newValue);
            }
        });



    }

    private void setTextToSuppliersValue(SuppliersEntity newValue) {
        txtSupplierId.setText(newValue.getSupplierId().toString());
        txtSupplierName.setText(newValue.getSuppliersName());
        txtContact.setText(newValue.getSuppliersContact());
        txtAddress.setText(newValue.getSuppliersAddress());
        txtProductName.setText(newValue.getSuppliersProductName());
    }

    private void setTextToValues(ProductsEntity newValue) {

         txtItemCode.setText(newValue.getItemCode().toString());
         txtItemName.setText(newValue.getItemName());
         txtSize.setText(newValue.getSize());
         txtPrice.setText(newValue.getPrice().toString());
         txtQuantity.setText(newValue.getQty().toString());
         cmbCategory.setValue(newValue.getCategory());
    }
}
