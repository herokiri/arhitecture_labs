package ru.dstu.sergey.laba1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import ru.dstu.sergey.laba1.sorts.SortLab;

import java.util.Arrays;

public class MainController {
    public TextField inputField;
    public TextArea outputArea;
    public RadioButton heapMethod;
    public RadioButton shellMethod;
    public RadioButton mergeMethod;
    @FXML
    private RadioButton insertionMethod;
    @FXML
    private RadioButton selectionMethod;
    @FXML
    private RadioButton bubbleMethod;
    @FXML
    private RadioButton quickMethod;
    ToggleGroup toggleGroup = new ToggleGroup();

    String prevRes = "";

    int count = 0;

    @FXML
    public void initialize() {

        insertionMethod.setToggleGroup(toggleGroup);
        selectionMethod.setToggleGroup(toggleGroup);
        bubbleMethod.setToggleGroup(toggleGroup);
        quickMethod.setToggleGroup(toggleGroup);
        heapMethod.setToggleGroup(toggleGroup);
        mergeMethod.setToggleGroup(toggleGroup);
        shellMethod.setToggleGroup(toggleGroup);


    }

    private void sortArray(String selectedMethod) {
        String inputText = inputField.getText();
        String[] inputArray = inputText.split("\\s+");

        try {
            int[] numbers = Arrays.stream(inputArray)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            long startTime = System.nanoTime();

            switch (selectedMethod) {
                case "Вставками":
                    System.out.println(Arrays.toString(numbers));
                    SortLab.insertion(numbers);
                    break;
                case "Выбором":
                    SortLab.selection(numbers);
                    break;
                case "Быстрая":
                    SortLab.quick(numbers, 0, numbers.length - 1);
                    break;
                case "Обменом":
                    SortLab.bubble(numbers);
                    break;
                case "Пирамидальная":
                    SortLab.heap(numbers);
                    break;
                case "Шелла":
                    SortLab.shell(numbers);
                    break;
                case "Слиянием":
                    SortLab.merge(numbers, 0, numbers.length - 1);
                    break;
            }
            long endTime = System.nanoTime();

            double timeElapsed = (double) (endTime - startTime) / 1000000;

            prevRes += count++ + ". " + Arrays.toString(numbers) + " : " + selectedMethod + " " + timeElapsed + "ms" + '\n';
            outputArea.setText(prevRes);
        } catch (NumberFormatException e) {
            outputArea.setText("Ошибка: Некорректный ввод чисел.");
        }
    }

    public void sortButtonClicked(ActionEvent actionEvent) {
        RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
        String selectedMethod = selectedRadioButton.getText();

        sortArray(selectedMethod);
    }
}