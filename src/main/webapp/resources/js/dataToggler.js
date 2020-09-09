
$(document).ready(function() {
                   rowExpansion(PF('tabela'));
                });
                
                
// Funcao alterada da solucao encontrada em https://stackoverflow.com/questions/31570538/expand-primefaces-rowexpansion-on-rowselect
function rowExpansion(dataTable) {
       //dataTable should be the widgetVar object
            var $this = dataTable;
            //add the 'hand' when hovering on row
            $this.tbody.children('tr').css('cursor', 'pointer');
            $this.tbody.off('click.datatable-expansion', '> tr')
               .on('click.datatable-expansion', "> tr[class~='ui-datatable-selectable']", null , function() { 
                   //TESTE SE JA ESTA EXPANDIDO
                    if( $(this).hasClass("ui-expanded-row") == false)
                        $this.collapseAllRows();    
                    $this.toggleExpansion($(this).find('div.ui-row-toggler'));    
                    rc();
                });
            // retira o evento dentro do panel grid
            $this.tbody.off('click.datatable-expansion', ".panelgrid ");   
       }
       