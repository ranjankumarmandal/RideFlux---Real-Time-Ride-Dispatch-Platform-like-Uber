// For debugging purpose

@RestController
@RequestMapping("/api/v1/trips")
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;

    @PostMapping("/end/{tripId}")
    public Mono<Void> endTrip(@PathVariable String tripId) {
        return tripService.endTrip(tripId);
    }
}