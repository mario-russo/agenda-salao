<script setup lang="ts">
import { ref, reactive, onMounted } from "vue";
import createServicos from "../components/ModalInputServicos.vue";
// import {Agendamento} from "../domain/Agendamento"

import configAxios from "../axios/configAxios";
import { Servico } from "../domain/Servico";

const columns = [
  {
    name: "id",
    required: true,
    label: "Id",
    align: "left",
    field: "id",
  },
  {
    name: "nome",
    align: "center",
    label: "nome",
    field: "nome",
  },
  {
    name: "preco",
    label: "preco ",
    field: "preco",
  },
  {
    name: "editar",
    label: "editar",
   
  },
  {
    name: "excluir",
    label: "Excluir",
   
  },
];

const rows = ref([]);

async function axios() {
  const resul = await configAxios.get("/servico");
  rows.value = resul.data;
}

const toolbar = ref(false);


onMounted(() => {
  axios();
});
</script>
<template>
    <div class="container">
      <div class="filho">
        <div>
          <q-table :rows="rows" :columns="columns" row-key="name" color="amber">
            <template v-slot:top>
              <h5>Lista de Agendamento</h5>
              <q-space />
              <q-btn
                class="btn"
                round
                color="positive"
                size="md"
                icon="add"
                @click="toolbar = true"
              />
            </template>
          </q-table>
        </div>  
      </div>
      <div>
        <q-dialog  full-height v-model="toolbar">
          <q-card style="width: 1000px; max-width: 80vw;">
            <q-toolbar>
              <q-avatar>
                <img src="https://cdn.quasar.dev/logo-v2/svg/logo.svg" />
              </q-avatar>
  
              <q-toolbar-title
                ><span class="text-weight-bold">Agendamento</span>
                Insira os dados para um novo agendamento</q-toolbar-title
              >
  
              <q-btn flat round dense icon="close" v-close-popup />
            </q-toolbar>
  
            <q-card-section>
              <createServicos></createServicos>
            </q-card-section>
          </q-card>
        </q-dialog>
      </div>
    </div>
  </template>
<style scoped>
.container {
  width: 100%;
  height: auto - 100px;
}

.filho {
  margin: 50px auto;
  width: 70%;
}
.filho div {
  margin-bottom: 20px;
}
</style>
