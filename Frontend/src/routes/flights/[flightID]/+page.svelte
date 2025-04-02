<script context="module">
    import { PUBLIC_API_BASE } from '$env/static/public';

    export async function load({ params }) {
        // Check if flightID is missing in the URL parameters
        if (!params.flightID) {
            throw new Error("Flight ID is missing");  // This will help you detect missing flight IDs
        }

        console.log("Received flightID:", params.flightID);  // Log the received flightID for debugging

        try {
            const res = await fetch(`${PUBLIC_API_BASE}/flights/${params.flightID}`);
            if (!res.ok) {
                throw new Error('Failed to fetch flights');
            }

            const flights = await res.json();
            console.log("Fetched flights:", flights);  // Log the list of fetched flights

            // Find the flight with the matching flightID
            const flight = flights.find(f =>
                f.flightID?.trim().toLowerCase() === params.flightID?.trim().toLowerCase()
            );

            console.log("Found flight:", flight);  // Log the found flight (or undefined)

            if (!flight) {
                return {
                    status: 404,
                    error: new Error('Flight not found')
                };
            }

            return { flight };  // Return the flight data to be used in the template
        } catch (error) {
            console.error("Error loading flight:", error);
            return {
                status: 500,
                error: new Error(`Internal error: ${error.message}`)
            };
        }
    }




</script>

<script>
    export let data;
    const { flight } = data;

</script>

<h1 class="text-2xl font-bold mb-4">Flight Details</h1>

{#if flight}
    <ul class="space-y-2">
        <li><strong>Flight ID:</strong> {flight.flightID}</li>
        <li><strong>Origin:</strong> {flight.origin}</li>
        <li><strong>Destination:</strong> {flight.destination}</li>
        <li><strong>Flight Time:</strong> {flight.flightTime}</li>
    </ul>
{:else}
    <p class="text-red-600">Error: Flight details not found or server error.</p>
{/if}
