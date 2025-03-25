<script>
    import { api } from '$lib/api';

    let flightID = '';
    let origin = '';
    let destination = '';
    let flightTime = '';
    let successMessage = '';
    let errorMessage = '';

    async function createFlight() {
        successMessage = '';
        errorMessage = '';

        const newFlight = {
            flightID,
            origin,
            destination,
            flightTime
        };

        try {
            await api.create('flights', JSON.stringify(newFlight), {
                headers: { 'Content-Type': 'application/json' }
            });
            successMessage = `Flight ${flightID} created successfully!`;
            flightID = origin = destination = flightTime = '';
        } catch (error) {
            errorMessage = `Error: ${error.message}`;
        }
    }
</script>

<h1 class="text-2xl font-bold mb-4">Create a New Flight</h1>

<form on:submit|preventDefault={createFlight} class="space-y-4 max-w-md">
    <div>
        <label>Flight ID</label>
        <input bind:value={flightID} class="w-full p-2 border rounded" required />
    </div>
    <div>
        <label>Origin</label>
        <input bind:value={origin} class="w-full p-2 border rounded" required />
    </div>
    <div>
        <label>Destination</label>
        <input bind:value={destination} class="w-full p-2 border rounded" required />
    </div>
    <div>
        <label>Flight Time</label>
        <input bind:value={flightTime} class="w-full p-2 border rounded" required />
    </div>

    <button type="submit" class="w-full bg-blue-600 text-white p-2 rounded hover:bg-blue-700">
        Create Flight
    </button>

    {#if successMessage}
        <p class="text-green-600 mt-2">{successMessage}</p>
    {/if}

    {#if errorMessage}
        <p class="text-red-600 mt-2">{errorMessage}</p>
    {/if}
</form>
