<script>
    import { api } from '$lib/api';
    import { PUBLIC_API_BASE } from '$env/static/public';
    import {goto} from '$app/navigation'

    let origin = '';
    let destination = '';
    let flights = [];
    let error = '';

    console.log("Backend base URL:", PUBLIC_API_BASE);

    async function searchFlights() {
        error = '';
        flights = [];

        try {
            const params = new URLSearchParams({ origin, destination});
            flights = await api.all(`flights/search?${params}`);
        } catch (e) {
            error = e.message;
            console.error("Error fetching flights:", e);
        }
    }
</script>

<h2>Search Flights</h2>

<form on:submit|preventDefault={searchFlights} class="space-y-2">
    <input bind:value={origin} placeholder="Origin" required class="p-2 border rounded w-full" />
    <input bind:value={destination} placeholder="Destination" required class="p-2 border rounded w-full" />
    <button type="submit" class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700">Search</button>
</form>

{#if error}
    <p class="text-red-500 mt-2">{error}</p>
{/if}

{#if flights.length > 0}
    <h3 class="mt-4 text-lg font-semibold">Results:</h3>
    <ul class="mt-2 space-y-1">
        {#each flights as flight}
            <li class="bg-gray-100 p-2 rounded">
                <span>
                    <strong>{flight.flightID}</strong>: {flight.origin} → {flight.destination} at {flight.flightTime}
                </span>
                <button
                        on:click={() => goto(`/flights/${flight.flightID}`)}
                        class="ml-4 bg-blue-600 text-white px-3 py-1 rounded hover:bg-blue-700">
                    See
                </button>
            </li>
        {/each}
    </ul>
{:else if origin && destination}
    <p class="mt-2">No flights found.</p>
{/if}
