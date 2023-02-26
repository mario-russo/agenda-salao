<script setup lang="ts">
import { ref, reactive, onMounted } from "vue";
import { QSpinnerGears, QTableProps, useQuasar } from "quasar";

import inputServico from "../components/ModalInputServicos.vue";
import { listAllServico } from "../axios/services/ServicoService";
import { Servico } from "../domain/Servico";

const q = useQuasar();
const columns: QTableProps["columns"] = [
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
    name: "actions",
    label: "Ações",
    field: "actions",
  },
];

const rows = ref<Servico[]>([]);

async function getAllServicos() {
  try {
    q.loading.show({
      spinner: QSpinnerGears,
    });
    const resul = await listAllServico();
    rows.value = resul;
    q.loading.hide();
  } catch (error) {
    erroLoading();
  }
}

function erroLoading() {
  q.loading.hide();

  q.notify({
    message: "Não foi possivel conectar com Sistema!!!",
    multiLine: true,
    type: "negative",
  });
}

function loadingCreateServico() {
  toolbar.value = false;
  getAllServicos();
}
const toolbar = ref(false);

onMounted(() => {
  getAllServicos();
});
</script>
<template>
  <div>
    <q-table :rows="rows" :columns="columns" row-key="name" color="amber">
      <template v-slot:top>
        <h5>Lista de Serviços</h5>
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

  <q-dialog v-model="toolbar">
    <q-card style="width: 1000px; max-width: 80vw">
      <q-toolbar>
        <q-avatar>
          <img src="https://cdn.quasar.dev/logo-v2/svg/logo.svg" />
        </q-avatar>

        <q-toolbar-title
          ><span class="text-weight-bold">Novo</span>Serviço</q-toolbar-title
        >

        <q-btn flat round dense icon="close" v-close-popup />
      </q-toolbar>

      <q-card-section>
        <inputServico @create-servicos="loadingCreateServico"></inputServico>
      </q-card-section>
    </q-card>
  </q-dialog>
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
