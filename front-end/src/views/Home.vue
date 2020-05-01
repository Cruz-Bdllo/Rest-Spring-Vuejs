<template>
    <div class="container">
        <h1 class="text-center mt-4">This page is home</h1>

        <!-- Table of clients -->
        <TableClient />
    </div>
</template>

<script>
    import TableClient from '@/components/TableClients';

    export default{
        name: 'Home',
        components: {TableClient}
    }
</script>