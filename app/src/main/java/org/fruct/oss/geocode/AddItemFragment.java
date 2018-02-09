package org.fruct.oss.geocode;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.fruct.oss.geopoint.Place;
import org.fruct.oss.geopoint.Point;
import org.fruct.oss.geopoint.ternary_value;
import org.fruct.oss.smartjavalog.base.TaskListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import sofia_kp.SIBResponse;

/**
 * Created by kulakov on 11.01.18.
 */

public class AddItemFragment extends Fragment {

    @BindView(R.id.btnOk)
    Button btnOk;

    @BindView(R.id.btnCancel)
    Button btnCancel;

    @BindView(R.id.tbLatitude)
    EditText tbLatitude;

    @BindView(R.id.tbLongitude)
    EditText tbLongitude;

    @BindView(R.id.rbgVertical)
    RadioGroup rbgVertical;

    @BindView(R.id.rbgHorizontal)
    RadioGroup rbgHorizontal;


    static Fragment getInstance() {
        return new AddItemFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        ButterKnife.bind(this, view);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).hideSoftKeyboard();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                getFragmentManager().popBackStack();
                ft.commit();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).hideSoftKeyboard();
                Double latitude;
                Double longitude;
                try {
                    latitude = Double.valueOf(tbLatitude.getText().toString());
                } catch (NumberFormatException ex) {
                    tbLatitude.setError("Not a double value");
                    return;
                }

                try {
                    longitude = Double.valueOf(tbLongitude.getText().toString());
                } catch (NumberFormatException ex) {
                    tbLongitude.setError("Not a double value");
                    return;
                }

                Place pl = Place.getInstance();
                Point pt = Point.getInstance();
                pl.setHasPoint(pt);
                pt.setHasLatitude(latitude);
                pt.setHasLongitude(longitude);

                int verLocation = rbgVertical.getCheckedRadioButtonId();
                switch (verLocation) {
                    case R.id.rbVertEquator: {
                        pl.setIsNorth(ternary_value.getInstance(0));
                        break;
                    }
                    case R.id.rbVertNorth: {
                        pl.setIsNorth(ternary_value.getInstance(true));
                        break;
                    }
                    case R.id.rbVertSauth: {
                        pl.setIsNorth(ternary_value.getInstance(false));
                        break;
                    }
                }
                int horLocation = rbgHorizontal.getCheckedRadioButtonId();
                switch (horLocation) {
                    case R.id.rbHorMeridian: {
                        pl.setIsWest(ternary_value.getInstance(0));
                        break;
                    }
                    case R.id.rbHorEast: {
                        pl.setIsWest(ternary_value.getInstance(false));
                        break;
                    }
                    case R.id.rbHorWest: {
                        pl.setIsWest(ternary_value.getInstance(true));
                        break;
                    }
                }

                pl.update().addListener(new TaskListener() {
                    @Override
                    public void onSuccess(SIBResponse response) {
                        pt.update().addListener(new TaskListener() {
                            @Override
                            public void onSuccess(SIBResponse response) {
                                Toast.makeText(getContext(), "Point was added successfully", Toast.LENGTH_LONG).show();
                                FragmentTransaction ft = getFragmentManager().beginTransaction();
                                getFragmentManager().popBackStack();
                                ft.commit();
                            }

                            @Override
                            public void onError(Exception ex) {
                                Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
                                ex.printStackTrace();
                            }
                        });
                    }

                    @Override
                    public void onError(Exception ex) {
                        Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
                        ex.printStackTrace();
                    }
                });
            }
        });

        return view;
    }
}
