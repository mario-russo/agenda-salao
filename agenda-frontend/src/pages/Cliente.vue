<script setup lang="ts">
import { ref, reactive, onMounted } from "vue";
import createCliente from "../components/modalInputCliente.vue";
import { listAllCliente } from "../axios/services/ClienteService";

import { QSpinnerGears, QTableProps, useQuasar } from "quasar";
import { Cliente } from "../domain/Cliente";

const columns: QTableProps["columns"] = [
  {
    name: "id",
    required: true,
    label: "ID",
    align: "left",
    field: "id",
  },
  {
    name: "nome",
    required: true,
    label: "Cliente",
    align: "left",
    field: "nome",
  },
  {
    name: "E-mail",
    align: "center",
    label: "Serviço",
    field: "email",
  },
  {
    name: "Telefone",
    label: "Data ",
    field: "telefone",
  },

  {
    name: "actions",
    label: "Ações",
    field: "actions",
  },
];

const rows = ref<Cliente[]>([]);
const quasar = useQuasar();

async function getAllCliente() {
  try {
    quasar.loading.show({
      spinner: QSpinnerGears,
    });
    quasar.loading.show();
    const resul = await listAllCliente();
    rows.value = resul;
    quasar.loading.hide();
  } catch (error) {
    erroLoading();
  }
}
function erroLoading() {
  quasar.loading.hide();

  quasar.notify({
    message: "Não foi possivel conectar com Sistema!!!",
    multiLine: true,
    type: "negative",
  });
}

function loadCreateCliente() {
  toolbar.value = false;
  getAllCliente();
}

const toolbar = ref(false);

onMounted(() => {
  getAllCliente();
});
</script>
<template>
  <div class="container">
    <div class="filho">
      <div>
        <q-table :rows="rows" :columns="columns" row-key="name" color="amber">
          <template v-slot:top>
            <h5>Lista de Clientes</h5>
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
          <template v-slot:body-cell-actions="props">
            <q-td :props="props">
              <q-btn icon="edit" color="info" size="sm" class="q-mr-sm" />
              <q-btn icon="delete" color="negative" size="sm" />
            </q-td>
          </template>
        </q-table>
      </div>
    </div>
    <div>
      <q-dialog v-model="toolbar">
        <q-card style="width: 1000px; max-width: 80vw">
          <q-toolbar>
            <q-avatar>
              
            </q-avatar>

            <q-toolbar-title
              ><span class="text-weight-bold">NOVO</span
              > - Cliente</q-toolbar-title
            >

            <q-btn flat round dense icon="close" v-close-popup />
          </q-toolbar>

          <q-card-section>
            <createCliente @create-cliente="loadCreateCliente"></createCliente>
          </q-card-section>
        </q-card>
      </q-dialog>
    </div>
  </div>
</template>
<style scoped>
div {
  margin-bottom: 20px;
}
</style>
