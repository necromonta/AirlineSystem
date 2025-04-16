<script>
    import {onMount} from "svelte";
    import {api} from "$lib/api.js";
    import { page } from '$app/state';

    let flight = $state({});

    onMount(() => {
        load()
    });

    const load = async () => {
        try{
            flight = await api.one("flights", page.params.slug);
        }catch (e) {
            // Handle the error
            console.log(e);
        }
    }
</script>

<h1 class="text-4xl">Flight</h1>

Do something with the flight data here.