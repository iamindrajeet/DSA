package observer_design_pattern;

public class TestObserverPattern {
	public static void main(String[] args) {
		NewsAgency observable = new NewsAgency();
		NewsChannel observer = new NewsChannel();

		observable.addObserver(observer);
		observable.setNews("news");
		//assertEquals(observer.getNews(), "news");
	}
}
