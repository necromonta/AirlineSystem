<script>
    import { onMount } from "svelte";

    let message = '';

    onMount(async () => {
        try {
            const response = await fetch('http://localhost:8080/api/v1/flights');
            if (response.ok) {
                message = await response.text();
            } else {
                message = 'Error fetching data';
            }
        } catch (err) {
            message = 'Fetch error: ' + err.message;
        }
    });

    let searchCriteria = {
        departure: '',
        arrival: '',
        travelDate: ''
    };

    const searchFlights = async (e) => {
        e.preventDefault();
        // Your code for searching flights...
    };

    let inputMessage = '';
    let responseMessage = '';

    async function submitMessage() {
        try {
            const response = await fetch('http://localhost:8080/api/v1/submit', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(inputMessage),
            });

            if (response.ok) {
                const data = await response.json();
                responseMessage = `Success: ${data.received}`;
            } else {
                responseMessage = 'Error sending message';
            }
        } catch (error) {
            responseMessage = 'Network error: ' + error.message;
        }
    }
</script>

<form on:submit={searchFlights}>
    <label>
        Departure:
        <input type="text" bind:value={searchCriteria.departure} required />
    </label>
    <label>
        Arrival:
        <input type="text" bind:value={searchCriteria.arrival} required />
    </label>
    <label>
        Travel Date:
        <input type="date" bind:value={searchCriteria.travelDate} required />
    </label>
    <button type="submit">Search</button>
</form>

<h1>Send a Message {message}</h1>
<input type="text" bind:value={inputMessage} placeholder="Type your message here" />
<button on:click={submitMessage}>Send</button>

{#if responseMessage}
   <p>{responseMessage}</p>
{/if}