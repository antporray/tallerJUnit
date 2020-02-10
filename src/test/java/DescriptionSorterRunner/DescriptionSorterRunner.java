package DescriptionSorterRunner;

import java.util.Comparator;

import org.junit.internal.runners.InitializationError;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Sorter;

@SuppressWarnings("deprecation")
public class DescriptionSorterRunner extends JUnit4ClassRunner  {

	private static final Comparator comparator = new Comparator() {

        public int compare(Description o1, Description o2) {
            return o1.getDisplayName().compareTo(o2.getDisplayName());
        }

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			return 0;
		}
    };
    
	public DescriptionSorterRunner(Class<?> klass) throws InitializationError {
		super(klass);
		// TODO Auto-generated constructor stub
		sort(new Sorter(comparator));
	}

}
