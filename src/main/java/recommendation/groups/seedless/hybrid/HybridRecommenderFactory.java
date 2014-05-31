package recommendation.groups.seedless.hybrid;

import java.util.Collection;
import java.util.Set;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import recommendation.groups.seedless.SeedlessGroupRecommender;
import recommendation.groups.seedless.SeedlessGroupRecommenderFactory;

public class HybridRecommenderFactory<V> implements SeedlessGroupRecommenderFactory<V>{

	boolean shouldPrintStatus = true;
	
	public HybridRecommenderFactory() {
		
	}
	
	public HybridRecommenderFactory(boolean shouldPrintStatus) {
		this.shouldPrintStatus = shouldPrintStatus;
	}
	
	@Override
	public SeedlessGroupRecommender<V> create(UndirectedGraph<V, DefaultEdge> graph) {
		HybridCliqueMerger<V> recommender = new HybridCliqueMerger<>(graph);
		recommender.setShouldPrintStatus(shouldPrintStatus);
		return recommender;
	}

	@Override
	public SeedlessGroupRecommender<V> create(UndirectedGraph<V, DefaultEdge> graph,
			Collection<Set<V>> maximalCliques) {
		HybridCliqueMerger<V> recommender = new HybridCliqueMerger<>(graph, maximalCliques);
		recommender.setShouldPrintStatus(shouldPrintStatus);
		return recommender;
	}

}
