import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.border.LineBorder;

public class Main_Frame extends JFrame implements ActionListener {
    JButton RECIPE_button;
    JButton FOOD_button;
    JButton EXPIRING_button;
    JPanel MAIN_panel;
    JButton recipe_back;
    JButton food_back;
    JButton food_add;
    JButton recipe_add;
    JButton expiring_back;
    JPanel RECIPE_panel;
    JPanel FOOD_panel;
    JPanel EXPIRING_panel;
    JButton r;
    ArrayList<String> recipes = new ArrayList<String>();
    ArrayList<String> food_list = new ArrayList<String>();
    Main_Frame() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setSize(375,250);

        MAIN_panel = new JPanel();
        MAIN_panel.setLayout(new GridBagLayout());

        this.getContentPane().add(MAIN_panel,BorderLayout.CENTER);
        GridBagConstraints c = new GridBagConstraints();

        RECIPE_button = new JButton();
        RECIPE_button.setText("RECIPE");
        RECIPE_button.setPreferredSize(new Dimension(400, 120));
        RECIPE_button.setFont(new Font("Serif", Font.BOLD,60));
        RECIPE_button.setBackground(Color.LIGHT_GRAY);
        RECIPE_button.addActionListener(this);
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,10,10,80);
        MAIN_panel.add(RECIPE_button,c);

        FOOD_button = new JButton();
        FOOD_button.setText("FOOD");
        FOOD_button.setPreferredSize(new Dimension(400, 120));
        FOOD_button.setFont(new Font("Serif", Font.BOLD,60));
        FOOD_button.setBackground(Color.LIGHT_GRAY);
        FOOD_button.addActionListener(this);
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0,10,0,80);
        MAIN_panel.add(FOOD_button,c);


        JLabel GGG = new JLabel();
        GGG.setText("<html>gaslight gatekeep girlboss</html>");
        GGG.setFont(new Font("Papyrus", Font.BOLD, 50));
        GGG.setHorizontalAlignment(JLabel.CENTER);
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(20,10,0,10);
        MAIN_panel.add(GGG,c);

        JLabel GROCERIES_label = new JLabel();
        GROCERIES_label.setText("Groceries:______");
        GROCERIES_label.setFont(new Font("Serif",Font.BOLD,40));
        ImageIcon imageIcon = new ImageIcon("C:\\users\\Abigail\\Documents\\Fridge\\.git\\Fridge\\keyboard.png");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(400, 200, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        GROCERIES_label.setIcon(imageIcon);
        GROCERIES_label.setHorizontalTextPosition(JLabel.CENTER);
        GROCERIES_label.setVerticalTextPosition(JLabel.TOP);
        //GROCERIES_label.setPreferredSize(new Dimension(300,300));
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(20,10,10,10);
        MAIN_panel.add(GROCERIES_label,c);

        this.add(MAIN_panel);
        //this.pack();
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==RECIPE_button) {
            Recipe_Panel();
        } else if (e.getSource()==FOOD_button) {
            Food_Panel();
        } else if (e.getSource()==recipe_back) {
            RECIPE_panel.setVisible(false);
            MAIN_panel.setVisible(true);
            //this.getContentPane().add(MAIN_panel,BorderLayout.CENTER);
        } else if (e.getSource()==food_back) {
            FOOD_panel.setVisible(false);
            //this.setSize(375,250);
            MAIN_panel.setVisible(true);
            //this.getContentPane().add(MAIN_panel,BorderLayout.CENTER);
        } else if (e.getSource()==recipe_add) {
            String title = JOptionPane.showInputDialog(null,"Enter your recipe name:");
            if (title != null && title.length() != 0) {
                recipes.add(title);
                RECIPE_panel.setVisible(false);
                MAIN_panel.setVisible(true);
                Recipe_Panel();
            }
        } else if (e.getSource()==food_add) {
            String title = JOptionPane.showInputDialog(null,"Enter your food name:");
            String category = JOptionPane.showInputDialog(null,"Enter your food category:");
            FoodItem cur_food = new FoodItem();
            cur_food.setName(title);
            cur_food.setCategory(category);
            System.out.println(cur_food);
            if (title != null && title.length() != 0) {
                food_list.add(title);
                FOOD_panel.setVisible(false);
                MAIN_panel.setVisible(true);
                Food_Panel();
            }
        }
        for (int i=0; i<recipes.size();i++) {
            System.out.println("action listener works");
            System.out.println(e.getSource()==recipes.get(i));
            if (e.getSource()==r) {
                Recipe_Form(recipes.get(i));
                //pull up form for clicked recipe
            }
        }
        for (int i=0; i<food_list.size();i++) {
            if (e.getSource()==food_list.get(i)) {
                Food_Form(food_list.get(i));
                //pull up form for clicked food
            }
        }
    }
    public void Recipe_Form(String recipe) {
        System.out.println("in recipe form");
        RECIPE_panel.setVisible(false);

        JPanel recipe_form = new JPanel();
        recipe_form.setLayout(new GridLayout(3,1));
        JTextArea ingredients = new JTextArea();
        JTextArea instructions = new JTextArea();
        JLabel title = new JLabel();
        title.setText(recipe);
        recipe_form.add(title);
        recipe_form.add(ingredients);
        recipe_form.add(instructions);
        this.add(recipe_form);

    }

    public void Food_Form(String food) {

    }


    public void Recipe_Panel() {

        MAIN_panel.setVisible(false);
        RECIPE_panel = new JPanel();
        RECIPE_panel.setLayout(new GridLayout(1,2));

        GridBagConstraints c = new GridBagConstraints();

        JPanel recipeList = new JPanel();
        recipeList.setLayout(new GridBagLayout());
        JScrollPane recipeListPane = new JScrollPane(recipeList);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridBagLayout());

        JLabel recipe_title = new JLabel();
        recipe_title.setText("RECIPE LIST");
        recipe_title.setFont(new Font("Serif",Font.BOLD,80));
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10,10,20,10);
        recipeList.add(recipe_title,c);


        for (int i=0;i<recipes.size();i++) {
            r = new JButton();
            r.setText(recipes.get(i));
            r.setBackground(Color.LIGHT_GRAY);
            r.setBorder(new LineBorder(Color.GRAY));
            r.setPreferredSize(new Dimension(400,120));
            r.setFont(new Font("Serif", Font.BOLD,60));
            r.addActionListener(this);
            c.gridx = 0;
            c.gridy = i+1;
            c.insets = new Insets(10,10,10,10);
            recipeList.add(r,c);
        }

        recipe_back = new JButton();
        ImageIcon image = new ImageIcon(new ImageIcon("C:\\users\\Abigail\\Documents\\Fridge\\.git\\Fridge\\back_arrow.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        recipe_back.setIcon(image);
        recipe_back.setBackground(Color.LIGHT_GRAY);
        recipe_back.addActionListener(this);
        recipe_back.setBorder(new LineBorder(Color.GRAY));
        recipe_back.setPreferredSize(new Dimension(100,75));
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10,500,200,10);
        buttonsPanel.add(recipe_back,c);

        recipe_add = new JButton();
        ImageIcon plus = new ImageIcon(new ImageIcon("C:\\users\\Abigail\\Documents\\Fridge\\.git\\Fridge\\plus.png").getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));
        recipe_add.setIcon(plus);
        recipe_add.setBackground(Color.LIGHT_GRAY);
        recipe_add.addActionListener(this);
        recipe_add.setHorizontalTextPosition(JButton.RIGHT);
        recipe_add.setVerticalTextPosition(JButton.TOP);
        recipe_add.setBorder(new LineBorder(Color.GRAY));
        recipe_add.setPreferredSize(new Dimension(100,75));
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(200,500,10,10);
        buttonsPanel.add(recipe_add,c);

        RECIPE_panel.add(recipeListPane);
        RECIPE_panel.add(buttonsPanel);

        //JScrollPane scroll = new JScrollPane(RECIPE_panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(RECIPE_panel);
    }

    public void Food_Panel() {
        MAIN_panel.setVisible(false);
        FOOD_panel = new JPanel();
        FOOD_panel.setLayout(new GridLayout(1,2));

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridBagLayout());

        JPanel foodList = new JPanel();
        foodList.setLayout(new GridBagLayout());
        JScrollPane foodListPanel = new JScrollPane(foodList);
        
        GridBagConstraints c = new GridBagConstraints();

        JLabel food_title = new JLabel();
        food_title.setText("FOOD LIST");
        food_title.setFont(new Font("Serif",Font.BOLD,80));
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10,10,20,10);
        foodList.add(food_title,c);
        
        for (int i=0;i<food_list.size();i++) {
            JButton f = new JButton();
            f.setText(food_list.get(i));
            f.setBackground(Color.LIGHT_GRAY);
            f.setBorder(new LineBorder(Color.GRAY));
            f.setPreferredSize(new Dimension(400,120));
            f.setHorizontalAlignment(JLabel.CENTER);
            f.setFont(new Font("Serif", Font.BOLD,60));
            f.addActionListener(this);
            c.gridx = 0;
            c.gridy = i+1;
            c.insets = new Insets(10,10,10,10);
            foodList.add(f,c);
        }

        food_back = new JButton();
        ImageIcon image = new ImageIcon(new ImageIcon("C:\\users\\Abigail\\Documents\\Fridge\\.git\\Fridge\\back_arrow.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        food_back.setIcon(image);
        food_back.setBackground(Color.LIGHT_GRAY);
        food_back.addActionListener(this);
        food_back.setBorder(new LineBorder(Color.GRAY));
        food_back.setPreferredSize(new Dimension(100,75));
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(10,500,200,10);
        buttonsPanel.add(food_back,c);
        
        food_add = new JButton();
        ImageIcon plus = new ImageIcon(new ImageIcon("C:\\users\\Abigail\\Documents\\Fridge\\.git\\Fridge\\plus.png").getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));
        food_add.setIcon(plus);
        food_add.setBackground(Color.LIGHT_GRAY);
        food_add.addActionListener(this);
        food_add.setHorizontalTextPosition(JButton.RIGHT);
        food_add.setVerticalTextPosition(JButton.TOP);
        food_add.setBorder(new LineBorder(Color.GRAY));
        food_add.setPreferredSize(new Dimension(100,75));
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(200,500,10,10);
        buttonsPanel.add(food_add,c);

        FOOD_panel.add(foodListPanel);
        FOOD_panel.add(buttonsPanel);

        this.add(FOOD_panel);
    }
}
