package ranger.ractor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReactorTestApplicationTests {

	@Test
	public void empty() {
		Mono<String> emptyMono = Mono.empty();
		StepVerifier.create(emptyMono).verifyComplete();
		Flux<String> emptyFlux = Flux.empty();
		StepVerifier.create(emptyFlux).verifyComplete();
	}
    @Test
    public void initialized() {
    	Mono<String> nonEmptyMono = Mono.just("joel");
    	StepVerifier.create(nonEmptyMono).expectNext("joel").verifyComplete();
    	Flux<String > nonEmptyFlux = Flux.just("john","mike","Sarah");
    	StepVerifier.create(nonEmptyFlux).expectNext("john","Mike","Sarah").verifyComplete();
        Flux<String> fluxFromIterable = Flux.fromIterable(Arrays.asList("Tom", "Hardy", "Bane"));
        StepVerifier.create(fluxFromIterable).expectNext("Tom", "Hardy", "Bane").verifyComplete();
    }

    @Test
    public void operations() {
    	Mono<String> monoMap = Mono.just("James").map(s -> s.toLowerCase());
        StepVerifier.create(monoMap).expectNext("james").verifyComplete();

    	Flux<String> fluxMapFilter = Flux.just("Joel", "Kyle").filter(s->s.toUpperCase().startsWith("K")).map(s->s.toLowerCase());
        StepVerifier.create(fluxMapFilter).expectNext("kyle").verifyComplete();
    }
    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1, new NamedThreadFactory("DubboMonitorTimer", true));


    @Test
    public void zipping() {
    	
        Flux<String> titles = Flux.just("Mr.", "Mrs.");
        Flux<String> firstNames = Flux.just("John", "Jane");
        Flux<String> lastNames = Flux.just("Doe", "Blake");

        Flux<String> names = Flux
                .zip(titles, firstNames, lastNames)
                .map(t -> t.getT1() + " " + t.getT2() + " " + t.getT3());

        StepVerifier.create(names).expectNext("Mr. John Doe", "Mrs. Jane Blake").verifyComplete();

    	Flux<Long> delay = Flux.interval(Duration.ofMillis(5));
        Flux<String> firstNamesWithDelay = firstNames.zipWith(delay, (s, l) -> s);
        
        Flux<String> namesWithDelay = Flux
                .zip(titles, firstNamesWithDelay, lastNames)
                .map(t -> t.getT1() + " " + t.getT2() + " " + t.getT3());

        StepVerifier.create(namesWithDelay).expectNext("Mr. John Doe", "Mrs. Jane Blake").verifyComplete();
    }
    
    @Test
    public void interleave() {
        Flux<Long> delay = Flux.interval(Duration.ofMillis(5));
        Flux<String> alphabetsWithDelay = Flux.just("A", "B").zipWith(delay, (s, l) -> s);
        Flux<String> alphabetsWithoutDelay = Flux.just("C", "D");

        Flux<String> interleavedFlux = alphabetsWithDelay.mergeWith(alphabetsWithoutDelay);
        StepVerifier.create(interleavedFlux).expectNext("C", "D", "A", "B").verifyComplete();

        Flux<String> nonInterleavedFlux = alphabetsWithDelay.concatWith(alphabetsWithoutDelay);
        StepVerifier.create(nonInterleavedFlux).expectNext("A", "B", "C", "D").verifyComplete();
    }

    @Test
    public void block() {
        String name = Mono.just("Jesse").block();
        assertEquals("Jesse", name);

        Iterator<String> namesIterator = Flux.just("Tom", "Peter").toIterable().iterator();
        assertEquals("Tom", namesIterator.next());
        assertEquals("Peter", namesIterator.next());
        assertFalse(namesIterator.hasNext());
    }
    
    
    
    
    
    
    
    
    
    
    
}
