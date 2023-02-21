<script setup lang="ts">
import { ref,reactive } from 'vue';
interface agendamento {
    cliente?:string
    servico?:string
    data ?:string
    hora ?:string
    atendente?:string
    endereco ?:string
}
const ph = ref('')
const dense = ref(true)
const dados = reactive<agendamento>({})
    

</script>
<template>
    <div class="container">
        <div class="filho">
            <div  v-for="dado in dados">
                <q-input class="input" v-model="dados.cliente" :label="dado" placeholder="Placeholder" hint="With placeholder" :dense="dense" />
                <q-input class="input" v-model="dados.servico" :label="dado" placeholder="Placeholder" hint="With placeholder" :dense="dense" />
                <q-input class="input" v-model="dados.data" :label="dado" placeholder="Placeholder" hint="With placeholder" :dense="dense" />
                <q-input class="input" v-model="dados.hora" :label="dado" placeholder="Placeholder" hint="With placeholder" :dense="dense" />
                <q-input class="input" v-model="dados.atendente" :label="dado" placeholder="Placeholder" hint="With placeholder" :dense="dense" />
                <q-input class="input" v-model="dados.endereco" :label="dado" placeholder="Placeholder" hint="With placeholder" :dense="dense" />
            </div>
        </div>

    </div>
</template>
<style scoped>
.container {
    width: 100%;
    height: auto - 100px;
}

.filho{
    margin:50px auto;
    width: 70%;
}
</style>