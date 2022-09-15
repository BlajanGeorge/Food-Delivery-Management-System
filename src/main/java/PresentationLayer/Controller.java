package PresentationLayer;

import BusinessLayer.*;
import BusinessLayer.MenuItem;
import DataLayer.Serializator;
import PresentationLayer.UserGraphicalInterface.*;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;

public class Controller extends Observable {
    private final DeliveryService deliveryService;
    EmployeeGraphicalUserInterface employeeGraphicalUserInterface;
    private int userID;


    public Controller(UserGraphicalInterface userGraphicalInterface,Model model)
    {
        userGraphicalInterface.setVisible(true);
        this.employeeGraphicalUserInterface = new EmployeeGraphicalUserInterface();
        this.deliveryService = new DeliveryService();
        Serializator.deserialization();
        deliveryService.isWellFormed();
        deliveryService.addObserver(employeeGraphicalUserInterface);

        userGraphicalInterface.getCreateAccount().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                userGraphicalInterface.setVisible(false);
                CreateAccountInterface createAccountInterface = new CreateAccountInterface();
                createAccountInterface.setVisible(true);
                createAccountInterface.getBackLabel().addMouseListener(new MouseListener() {
                   @Override
                   public void mouseClicked(MouseEvent e) {
                       userGraphicalInterface.setVisible(true);
                       createAccountInterface.dispose();
                   }

                   @Override
                   public void mousePressed(MouseEvent e) {

                   }

                   @Override
                   public void mouseReleased(MouseEvent e) {

                   }

                   @Override
                   public void mouseEntered(MouseEvent e) {

                   }

                   @Override
                   public void mouseExited(MouseEvent e) {

                   }
               });
              createAccountInterface.getLoginLabel().addMouseListener(new MouseListener() {
                  @Override
                  public void mouseClicked(MouseEvent e) {
                      model.addUser(createAccountInterface.getUsername(),createAccountInterface.getPassword(),createAccountInterface.getRole());
                      createAccountInterface.setField("");
                  }

                  @Override
                  public void mousePressed(MouseEvent e) {

                  }

                  @Override
                  public void mouseReleased(MouseEvent e) {

                  }

                  @Override
                  public void mouseEntered(MouseEvent e) {

                  }

                  @Override
                  public void mouseExited(MouseEvent e) {

                  }
              });

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        userGraphicalInterface.getLoginLabel().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int rez=model.checkUser(userGraphicalInterface.getUsername(),userGraphicalInterface.getPassword());
                userID=model.getUserID(userGraphicalInterface.getUsername(),userGraphicalInterface.getPassword());
                userGraphicalInterface.setField("");
                if(rez == -1) {
                    return;
                }
                else
                {
                    userGraphicalInterface.setVisible(false);

                    if(rez == 1)
                    {
                        AdministratorGraphicalUserInterface administratorGraphicalUserInterface = new AdministratorGraphicalUserInterface();
                        administratorGraphicalUserInterface.setVisible(true);
                        administratorGraphicalUserInterface.getBackLabel().addMouseListener(new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                userGraphicalInterface.setVisible(true);
                                administratorGraphicalUserInterface.dispose();
                            }

                            @Override
                            public void mousePressed(MouseEvent e) {

                            }

                            @Override
                            public void mouseReleased(MouseEvent e) {

                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {

                            }

                            @Override
                            public void mouseExited(MouseEvent e) {

                            }
                        });
                        administratorGraphicalUserInterface.getImportButton().addActionListener(e1 -> deliveryService.importBaseProducts());
                        administratorGraphicalUserInterface.getShowButton().addActionListener(e12 -> {
                            administratorGraphicalUserInterface.setVisible(false);
                            ShowProductsView showProductsView = new ShowProductsView(deliveryService.showProducts());
                            showProductsView.getBackBtn().addActionListener(e121 -> {
                                administratorGraphicalUserInterface.setVisible(true);
                                showProductsView.dispose();
                            });
                        });

                                administratorGraphicalUserInterface.getAddButton().addActionListener(e13 -> {
                                    administratorGraphicalUserInterface.setVisible(false);
                                    TypeInterface typeInterface = new TypeInterface();

                                    typeInterface.getBackBtn().addActionListener(e131 -> {
                                        administratorGraphicalUserInterface.setVisible(true);
                                        typeInterface.dispose();
                                    });
                                    typeInterface.getBaseProductBtn().addActionListener(e1312 -> {
                                        typeInterface.setVisible(false);
                                        BaseProductAddInterface baseProductAddInterface = new BaseProductAddInterface();
                                        baseProductAddInterface.getBtnBack().addActionListener(e13121 -> {
                                            baseProductAddInterface.dispose();
                                            typeInterface.setVisible(true);
                                        });
                                        baseProductAddInterface.getBtnNewButton().addActionListener(e131212 -> {
                                            if(baseProductAddInterface.getField1().equals("") || baseProductAddInterface.getField2().equals("")
                                            || baseProductAddInterface.getField3().equals("") || baseProductAddInterface.getField4().equals("") || baseProductAddInterface.getField5().equals("")
                                        || baseProductAddInterface.getField6().equals("") || baseProductAddInterface.getField7().equals(""))
                                            {
                                                JOptionPane.showMessageDialog(null,
                                                        "Invalid!",
                                                        "Error!",
                                                        JOptionPane.ERROR_MESSAGE);

                                                return;
                                            }

                                            deliveryService.addProduct (
                                                    new BaseProduct(baseProductAddInterface.getField1(),Float.parseFloat(baseProductAddInterface.getField2()),
                                                            Integer.parseInt(baseProductAddInterface.getField3()),Integer.parseInt(baseProductAddInterface.getField4()),
                                                            Integer.parseInt(baseProductAddInterface.getField5()),Integer.parseInt(baseProductAddInterface.getField6()),
                                                            Integer.parseInt(baseProductAddInterface.getField7())));
                                                    baseProductAddInterface.clear("");
                                        });

                                    });
                                    typeInterface.getCompositeProductBtn().addActionListener(e1313 -> {
                                        ArrayList<MenuItem> array = new ArrayList<>();
                                        typeInterface.setVisible(false);
                                        CompositeProductAddInterface compositeProductAddInterface = new CompositeProductAddInterface();
                                        compositeProductAddInterface.setVisible(true);
                                        compositeProductAddInterface.getBackBtn().addActionListener(e13131 -> {
                                            typeInterface.setVisible(true);
                                            compositeProductAddInterface.dispose();
                                        });
                                        compositeProductAddInterface.getPutBtn().addActionListener(e131312 -> {
                                            String combo = compositeProductAddInterface.getCombo();
                                            if(deliveryService.findItem(combo) instanceof CompositeProduct)
                                            {
                                                MenuItem compositeProduct = deliveryService.findItem(combo);
                                                array.add(compositeProduct);
                                            }
                                            else {
                                                MenuItem baseProduct = deliveryService.findItem(combo);
                                                array.add(baseProduct);
                                            }
                                        });
                                        compositeProductAddInterface.getAddBtn().addActionListener(e131313 -> {
                                            String title = compositeProductAddInterface.getTitle();
                                            if(title.equals(""))
                                            {
                                                JOptionPane.showMessageDialog(null,
                                                        "Invalid!",
                                                        "Error!",
                                                        JOptionPane.ERROR_MESSAGE);
                                                return;
                                            }
                                            deliveryService.addProduct(new CompositeProduct(title,array));
                                            compositeProductAddInterface.setField("");
                                        });
                                    });

                                });
                                administratorGraphicalUserInterface.getDeleteButton().addActionListener(e14 -> {
                                    administratorGraphicalUserInterface.setVisible(false);
                                    DeleteProductInterface deleteProductInterface = new DeleteProductInterface();
                                    deleteProductInterface.setVisible(true);

                                    deleteProductInterface.getBackBtn().addActionListener(e141 -> {
                                        deleteProductInterface.dispose();
                                        administratorGraphicalUserInterface.setVisible(true);

                                    });
                                    deleteProductInterface.getDeleteBtn().addActionListener(e1412 -> {
                                        String combo = deleteProductInterface.getCombo();
                                        MenuItem menuItem = deliveryService.findItem(combo);
                                        deliveryService.deleteProduct(menuItem);
                                    });

                                });
                                administratorGraphicalUserInterface.getEditButton().addActionListener(e15 -> {
                                    administratorGraphicalUserInterface.setVisible(false);
                                    EditProductInterface editProductInterface = new EditProductInterface();
                                    editProductInterface.setVisible(true);

                                    editProductInterface.getBtnBack().addActionListener(e151 -> {
                                        administratorGraphicalUserInterface.setVisible(true);
                                        editProductInterface.dispose();
                                    });
                                    editProductInterface.getBtnNewButton().addActionListener(e1512 -> {
                                        if(editProductInterface.getField1().equals("") || editProductInterface.getField2().equals("")
                                                || editProductInterface.getField3().equals("") || editProductInterface.getField4().equals("") || editProductInterface.getField5().equals("")
                                                || editProductInterface.getField6().equals("") || editProductInterface.getField7().equals(""))
                                        {
                                            JOptionPane.showMessageDialog(null,
                                                    "Invalid!",
                                                    "Error!",
                                                    JOptionPane.ERROR_MESSAGE);

                                            return;
                                        }

                                        deliveryService.editProduct( deliveryService.findItem(editProductInterface.getCombo()),new BaseProduct(editProductInterface.getField1(),Float.parseFloat(editProductInterface.getField2()),
                                                Integer.parseInt(editProductInterface.getField3()),Integer.parseInt(editProductInterface.getField4()),
                                                Integer.parseInt(editProductInterface.getField5()),Integer.parseInt(editProductInterface.getField6()),
                                                Integer.parseInt(editProductInterface.getField7())));
                                        editProductInterface.clear("");
                                    });

                                });
                                administratorGraphicalUserInterface.getReportOne().addActionListener(e16 -> {
                                    administratorGraphicalUserInterface.setVisible(false);
                                    ReportOneInterface reportOneInterface = new ReportOneInterface();
                                    reportOneInterface.setVisible(true);
                                    reportOneInterface.getBackBtn().addActionListener(e161 -> {
                                        administratorGraphicalUserInterface.setVisible(true);
                                        reportOneInterface.dispose();
                                    });
                                    reportOneInterface.getGenerateBtn().addActionListener(e1612 -> {
                                        if(reportOneInterface.getStartHour().equals("") ||
                                                reportOneInterface.getStartMinutes().equals("") ||
                                                reportOneInterface.getEndHour().equals("") ||
                                                reportOneInterface.getEndMinutes().equals(""))
                                        {
                                            JOptionPane.showMessageDialog(null,
                                                    "Invalid!",
                                                    "Error!",
                                                    JOptionPane.ERROR_MESSAGE);

                                            return;
                                        }
                                        deliveryService.reportOne(Integer.parseInt(reportOneInterface.getStartHour()),
                                                Integer.parseInt(reportOneInterface.getStartMinutes()),Integer.parseInt(reportOneInterface.getEndHour())
                                        ,Integer.parseInt(reportOneInterface.getEndMinutes()));
                                        reportOneInterface.clear();
                                    });
                                });
                                administratorGraphicalUserInterface.getReportTwo().addActionListener(e17 -> {
                                    administratorGraphicalUserInterface.setVisible(false);
                                    ReportTwoInterface reportTwoInterface = new ReportTwoInterface();
                                    reportTwoInterface.setVisible(true);

                                    reportTwoInterface.getBackButton().addActionListener(e171 -> {
                                        administratorGraphicalUserInterface.setVisible(true);
                                        reportTwoInterface.dispose();
                                    });
                                    reportTwoInterface.getGenerateButton().addActionListener(e1712 -> {
                                        if(reportTwoInterface.getNumber().equals(""))
                                        {
                                            JOptionPane.showMessageDialog(null,
                                                    "Invalid!",
                                                    "Error!",
                                                    JOptionPane.ERROR_MESSAGE);

                                            return;
                                        }
                                        deliveryService.reportTwo(Integer.parseInt(reportTwoInterface.getNumber()));
                                        reportTwoInterface.clear();
                                    });
                                });
                                administratorGraphicalUserInterface.getReportThree().addActionListener(e18 -> {
                                    administratorGraphicalUserInterface.setVisible(false);
                                    ReportThreeInterface reportThreeInterface = new ReportThreeInterface();
                                    reportThreeInterface.setVisible(true);

                                    reportThreeInterface.getBackBtn().addActionListener(e181 -> {
                                        administratorGraphicalUserInterface.setVisible(true);
                                        reportThreeInterface.dispose();
                                    });
                                    reportThreeInterface.getGenerateBtn().addActionListener(e1812 -> {
                                        if(reportThreeInterface.getNumberOfOrders().equals("") ||
                                                reportThreeInterface.getValuerPerOrder().equals(""))
                                        {
                                            JOptionPane.showMessageDialog(null,
                                                    "Invalid!",
                                                    "Error!",
                                                    JOptionPane.ERROR_MESSAGE);

                                            return;
                                        }
                                        deliveryService.reportThree(Integer.parseInt(reportThreeInterface.getNumberOfOrders()),
                                                Integer.parseInt(reportThreeInterface.getValuerPerOrder()));
                                        reportThreeInterface.clear();
                                    });
                                });
                                administratorGraphicalUserInterface.getReportFour().addActionListener(e19 -> {
                                    administratorGraphicalUserInterface.setVisible(false);
                                    ReportFourInterface reportFourInterface = new ReportFourInterface();
                                    reportFourInterface.setVisible(true);
                                    reportFourInterface.getBackButton().addActionListener(e191 -> {
                                        administratorGraphicalUserInterface.setVisible(true);
                                        reportFourInterface.dispose();
                                    });
                                    reportFourInterface.getGenerateButton().addActionListener(e1912 -> {
                                        int index=reportFourInterface.getIndexOfComboBox();
                                        deliveryService.reportFour(index);

                                    });
                                });
                            }
                        //admin panel
                    else
                    {
                        if(rez == 2)
                        {
                            employeeGraphicalUserInterface.setVisible(true);
                            employeeGraphicalUserInterface.getBackLabel().addMouseListener(new MouseListener() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    userGraphicalInterface.setVisible(true);
                                    employeeGraphicalUserInterface.dispose();
                                }

                                @Override
                                public void mousePressed(MouseEvent e) {

                                }

                                @Override
                                public void mouseReleased(MouseEvent e) {

                                }

                                @Override
                                public void mouseEntered(MouseEvent e) {

                                }

                                @Override
                                public void mouseExited(MouseEvent e) {

                                }
                            });
                            employeeGraphicalUserInterface.getStoreButton().addActionListener(e110 -> deliveryService.storeInfo());
                            //employee panel
                        }
                        else
                        {
                            if(rez == 3)
                            {
                                ClientGraphicalUserInterface clientGraphicalUserInterface = new ClientGraphicalUserInterface();
                                clientGraphicalUserInterface.setVisible(true);
                                clientGraphicalUserInterface.getBackLabel().addMouseListener(new MouseListener() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        userGraphicalInterface.setVisible(true);
                                        clientGraphicalUserInterface.dispose();
                                    }

                                    @Override
                                    public void mousePressed(MouseEvent e) {

                                    }

                                    @Override
                                    public void mouseReleased(MouseEvent e) {

                                    }

                                    @Override
                                    public void mouseEntered(MouseEvent e) {

                                    }

                                    @Override
                                    public void mouseExited(MouseEvent e) {

                                    }
                                });
                                clientGraphicalUserInterface.getShowButton().addActionListener(e111 -> {
                                    clientGraphicalUserInterface.setVisible(false);
                                    ShowProductsView showProductsView = new ShowProductsView(deliveryService.showProducts());
                                    showProductsView.getBackBtn().addActionListener(e1111 -> {
                                        clientGraphicalUserInterface.setVisible(true);
                                        showProductsView.dispose();
                                    });
                                });
                                clientGraphicalUserInterface.getSearchButton().addActionListener(e112 -> {
                                    clientGraphicalUserInterface.setVisible(false);
                                    SearchInterface searchInterface = new SearchInterface();
                                    searchInterface.setVisible(true);

                                    searchInterface.getBackBtn().addActionListener(e1121 -> {
                                        clientGraphicalUserInterface.setVisible(true);
                                        searchInterface.dispose();
                                    });
                                    searchInterface.getSearchBtn().addActionListener(e11212 -> {
                                        String title = searchInterface.getTitle();
                                        String rating = searchInterface.getRating();
                                        String calories = searchInterface.getCalories();
                                        String protein = searchInterface.getProtein();
                                        String fat = searchInterface.getFat();
                                        String sodium = searchInterface.getSodium();
                                        String price = searchInterface.getPrice();

                                        searchInterface.setVisible(false);
                                        ShowProductsView showProductsView = new ShowProductsView(deliveryService.search(title,rating,calories,protein,fat,sodium,price));
                                        searchInterface.clear();
                                        showProductsView.getBackBtn().addActionListener(e112121 -> {
                                            searchInterface.setVisible(true);
                                            showProductsView.dispose();
                                        });
                                    });
                                });
                                clientGraphicalUserInterface.getOrderButton().addActionListener(e113 -> {
                                    ArrayList<MenuItem> orderedProducts = new ArrayList<>();
                                    clientGraphicalUserInterface.setVisible(false);
                                    PlaceOrderInterface placeOrderInterface = new PlaceOrderInterface();
                                    placeOrderInterface.setVisible(true);
                                    placeOrderInterface.getBackBtn().addActionListener(e1131 -> {
                                        clientGraphicalUserInterface.setVisible(true);
                                        placeOrderInterface.dispose();
                                    });
                                    placeOrderInterface.getPutBtn().addActionListener(e11312 -> {
                                        MenuItem menuItem = deliveryService.findItem(placeOrderInterface.getComboElement());
                                        orderedProducts.add(menuItem);
                                    });
                                    placeOrderInterface.getOrderBtn().addActionListener(e11313 -> {
                                        deliveryService.addOrder(userID,orderedProducts);

                                        for(MenuItem i : orderedProducts)
                                        {
                                            i.increaseOrderedTimes();
                                        }
                                        orderedProducts.clear();
                                    });

                                });
                                //client panel
                            }
                        }
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
