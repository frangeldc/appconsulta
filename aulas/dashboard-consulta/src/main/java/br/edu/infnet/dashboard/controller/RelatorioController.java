package br.edu.infnet.dashboard.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Log;
import br.edu.infnet.dashboard.model.domain.Consulta;
import br.edu.infnet.dashboard.model.domain.Exame;
import br.edu.infnet.dashboard.model.service.LogService;
import br.edu.infnet.dashboard.model.service.ConsultaService;

@Controller
public class RelatorioController {
	
	@Autowired
	private ConsultaService consultaService;
	@Autowired
	private LogService logService;

	@GetMapping(value = "/generate")
	public String emissaoRelatorio(Model model) {
		
		Workbook workbook = new XSSFWorkbook();
		
		Sheet abaExames = workbook.createSheet("Exames");
				
		String[] columns = {"Data", "Especialidade", "Local", 
							"Nome do médico", "E-mail do médico", "CRM do médico", "UF médico",
							"Descrição do exame", "Preço do exame"};

		Row headerRow = abaExames.createRow(0);
		
		for(int i = 0; i < columns.length; i++) {
			headerRow.createCell(i).setCellValue(columns[i]);
		}
		
		List<Consulta> consultas = consultaService.obterLista();
		
		int rowNum = 0;
		
		for(Consulta consulta : consultas) {
			
			for(Exame exame : consulta.getExames()) {
				Row row = abaExames.createRow(++rowNum);
				
				row.createCell(0).setCellValue(
						consulta.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
					);
				row.createCell(1).setCellValue(consulta.getEspecialidade());
				row.createCell(2).setCellValue(consulta.getLocal());
				row.createCell(3).setCellValue(consulta.getMedico().getNome());
				row.createCell(4).setCellValue(consulta.getMedico().getEmail());
				row.createCell(5).setCellValue(consulta.getMedico().getCrm());
				row.createCell(6).setCellValue(
						consulta.getMedico().getEndereco() != null ? 
								consulta.getMedico().getEndereco().getUf() : ""
							);
				row.createCell(7).setCellValue(exame.getDescricao());
				row.createCell(8).setCellValue(exame.getPreco());
			}
		}
		
		LocalDateTime hoje = LocalDateTime.now(); 
		
		String arquivo = "exames"+hoje.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))+".xlsx";		

		String mensagem = null;
		try {
			workbook.write(new FileOutputStream(arquivo));

			workbook.close();

			mensagem = "A planilha gerada está disponível no diretório padrão!!!"; 
			
		} catch (IOException e) {
			mensagem = "Problemas na geração da planilha!!!";
			
			e.printStackTrace();
		}
		
		Log log = new Log();
		log.setData(hoje);
		log.setNome(mensagem);
		
		logService.incluir(log);
		
		return "redirect:/";
	}
}
