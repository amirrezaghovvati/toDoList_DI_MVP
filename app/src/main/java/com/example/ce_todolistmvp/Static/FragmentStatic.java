package com.example.ce_todolistmvp.Static;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.anychart.AnyChart;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.chart.common.listener.Event;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.charts.Pie;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;
import com.anychart.graphics.vector.SolidFill;
import com.anychart.standalones.Legend;
import com.example.ce_todolistmvp.Model.model.Month;
import com.example.ce_todolistmvp.R;
import com.example.ce_todolistmvp.databinding.StaticLayoutBinding;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

public class FragmentStatic extends Fragment implements StaticContract.StaticView {
    StaticLayoutBinding binding;
    @Inject
    StaticContract.StaticPresenter presenter;
    private StaticComponent component;
    private Month month;
    @Inject List<DataEntry> data ;
    @Inject Pie pie;

    @Inject SolidFill solidFill;
   @Named("two") SolidFill secondSolidFill;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        month=FragmentStaticArgs.fromBundle(getArguments()).getMonth();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=StaticLayoutBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        component=DaggerStaticComponent.factory().build(month,getContext(),"#00C853",1,"#FF4433",1);
        component.injectFields(this);
        secondSolidFill=component.crateSolidFillTwo();
        binding.tvMonthName.setText(month.getMonthName());
        pie.setOnClickListener(new ListenersInterface.OnClickListener(new String[]{"x", "value"}) {
            @Override
            public void onClick(Event event) {
                Toast.makeText(getContext(), event.getData().get("x") + ":" + event.getData().get("value"), Toast.LENGTH_SHORT).show();
            }
        });
        binding.backStatic.setOnClickListener(v->{presenter.onBackClicked();});

        binding.tvAddData.setOnClickListener(v->{presenter.onAddClicked();});



        pie.title("January Static");
        pie.labels().position("outside");
        pie.legend().title().enabled(true);
        pie.legend().title()
                .fontColor("#111")
                .text("Your static")
                .padding(0d, 0d, 10d, 10d);

        pie.legend()
                .position("center-bottom")
                .itemsLayout(LegendLayout.HORIZONTAL)
                .align(Align.CENTER);
        binding.anyChartView.setChart(pie);
        presenter.onAttach(this);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.onDetach();
    }

    @Override
    public void setChartInfoes(int dones, int unDones) {
        if (dones==0 && unDones==0){
            binding.emptyStateStatic.setVisibility(View.VISIBLE);
            binding.anyChartView.setVisibility(View.GONE);
        }else{
            binding.emptyStateStatic.setVisibility(View.GONE);
            binding.anyChartView.setVisibility(View.VISIBLE);
        data.add(new ValueDataEntry("Done Works", dones));
        data.add(new ValueDataEntry("UnDone Works", unDones));

        pie.data(data);
        pie.palette().itemAt(0,solidFill );
        pie.palette().itemAt(1,secondSolidFill);
        }
    }

    @Override
    public void onBack() {
        getActivity().onBackPressed();
    }

    @Override
    public void onAddItemClicked() {
        Navigation.findNavController(getView()).navigate(FragmentStaticDirections.actionFragmentStaticToFragmentMonth());
    }
}
