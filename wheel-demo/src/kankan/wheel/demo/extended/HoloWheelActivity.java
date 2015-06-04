package kankan.wheel.demo.extended;

import kankan.wheel.demo.extended.R;
import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.AbstractWheelTextAdapter;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class HoloWheelActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.cities_holo_layout);
		final String citiesString[] = new String[] { "New York", "Washington",
				"Chicago", "Atlanta", "Orlando" };
		final WheelView cities = (WheelView) findViewById(R.id.city);
		cities.setVisibleItems(5); // Number of items
		cities.setWheelBackground(R.drawable.wheel_bg_holo);
		cities.setWheelForeground(R.drawable.wheel_val_holo);
		cities.setShadowColor(0x00000000, 0x20000000, 0x00000000);
		cities.setViewAdapter(new CityAdapter(this, citiesString));
		cities.setCurrentItem(0);

		cities.addChangingListener(new OnWheelChangedListener() {

			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {

			}
		});
	}

	/**
	 * Adapter for countries
	 */
	private class CityAdapter extends AbstractWheelTextAdapter {
		// City names

		private String[] cities;

		/**
		 * Constructor
		 */
		protected CityAdapter(Context context, String[] valueStrings) {
			super(context, R.layout.city_holo_layout, NO_RESOURCE);
			this.cities = valueStrings;
			setItemTextResource(R.id.city_name);
		}

		@Override
		public View getItem(int index, View cachedView, ViewGroup parent) {
			View view = super.getItem(index, cachedView, parent);
			return view;
		}

		@Override
		public int getItemsCount() {
			return cities.length;
		}

		@Override
		protected CharSequence getItemText(int index) {
			return cities[index];
		}
	}
}
