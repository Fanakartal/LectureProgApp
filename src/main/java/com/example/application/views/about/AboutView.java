package com.example.application.views.about;

import com.example.application.data.entity.Lecture;
import com.example.application.data.entity.Lecturer;
import com.example.application.data.entity.Person;
import com.example.application.data.service.LectureService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.example.application.views.main.MainView;
import com.vaadin.flow.component.grid.Grid;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.artur.helpers.CrudServiceDataProvider;

import java.util.Optional;

@Route(value = "about", layout = MainView.class)
@PageTitle("About")
public class AboutView extends Div {

    //private Grid<Lecture> grid = new Grid<>(Lecture.class, true);
    Grid<Lecture> lectureGrid = new Grid<>(Lecture.class);
    private LectureService lectureService;

    public AboutView(LectureService lectureService) {
        this.lectureService = lectureService;
        setId("about-view");
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        add(lectureGrid);
        updateLectureList();

       /* Button button = new Button("Show the day at the date:");

        DatePicker datePicker = new DatePicker("Pick a date: ");
        TimePicker beginTimePicker = new TimePicker("Pick a begin time: ");
        TimePicker endTimePicker = new TimePicker("Pick an end time: ");

        HorizontalLayout layout = new HorizontalLayout(button, datePicker, beginTimePicker, endTimePicker);
        button.addClickListener(click -> add(new Paragraph("Clicked at the day: " + datePicker.getValue().getDayOfWeek())));
        button.addClickListener(click -> add(new Paragraph("Clicked at the hour: " + beginTimePicker.getValue())));
        button.addClickListener(click -> add(new Paragraph("Clicked at the hour: " + endTimePicker.getValue())));

        layout.setDefaultVerticalComponentAlignment(Alignment.END);
        add(layout);*/
    }

    private void updateLectureList()
    {
        lectureGrid.setItems(lectureService.findAll());
    }

    private void configureGrid()
    {
        lectureGrid.addClassName("lecture-grid");
        lectureGrid.setSizeFull();
        //lectureGrid.removeColumnByKey("lecturer");
        lectureGrid.setColumns("code", "name"/*, "lecturer"*/, "dayOfWeek", "beginTime", "endTime");

        /*lectureGrid.addColumn(lecture -> {
            Lecturer lecturer = lecture.getLecturer();
            return lecturer != null ? lecturer.getName() : "-";
        }).setHeader("Lecturer");*/

        lectureGrid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    /*private Grid<Lecture> grid = new Grid<>(Lecture.class, false);

    private BeanValidationBinder<Lecture> binder;

    private Lecture lecture;

    public AboutView(@Autowired LectureService lectureService)
    {
        SplitLayout splitLayout = new SplitLayout();
        splitLayout.setSizeFull();

        createGridLayout(splitLayout);
        //createEditorLayout(splitLayout);

        add(splitLayout);

        grid.addColumn("code").setAutoWidth(true);
        grid.addColumn("name").setAutoWidth(true);
        grid.addColumn("lecturer").setAutoWidth(true);
        grid.addColumn("dayOfWeek").setAutoWidth(true);
        grid.addColumn("beginTime").setAutoWidth(true);
        grid.addColumn("endTime").setAutoWidth(true);

        grid.setDataProvider(new CrudServiceDataProvider<>(lectureService));
        grid.setHeightFull();

        // when a row is selected or deselected, populate form
        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() != null) {
                Optional<Lecture> lectureFromBackend = lectureService.get(event.getValue().getId());
                // when a row is selected but the data is no longer available, refresh grid
                if (lectureFromBackend.isPresent()) {
                    populateForm(lectureFromBackend.get());
                } else {
                    refreshGrid();
                }
            } else {
                clearForm();
            }
        });

        // Configure Form
        binder = new BeanValidationBinder<>(Lecture.class);


    }

    private void createGridLayout(SplitLayout splitLayout) {
        Div wrapper = new Div();
        wrapper.setId("grid-wrapper");
        wrapper.setWidthFull();
        splitLayout.addToPrimary(wrapper);
        wrapper.add(grid);
    }

    private void refreshGrid() {
        grid.select(null);
        grid.getDataProvider().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(Lecture value) {
        this.lecture = value;
        binder.readBean(this.lecture);

    }*/

}
