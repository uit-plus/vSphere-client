package com.github.kubesys.vsphere.login;

import java.net.URLEncoder;

import com.github.kubesys.vsphere.VsphereClientTest;


/**
 * Unit test for simple App.
 */
public class UrlEncodeTest extends VsphereClientTest {
	
	static String value = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48c2FtbDJwOlJlc3BvbnNlIHht\r\n" + 
			"bG5zOnNhbWwycD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOnByb3RvY29sIiBEZXN0aW5h\r\n" + 
			"dGlvbj0iaHR0cHM6Ly8xMzMuMTMzLjEzNS4zNS91aS9zYW1sL3dlYnNzby9zc28iIElEPSJfMDE2\r\n" + 
			"NGUzYmY2YzhmZDlhYzMyYmZhY2NkZTAyNTA4MGIiIEluUmVzcG9uc2VUbz0iXzUzOWEyNGY3NWNk\r\n" + 
			"OGI4ZDBiZjcxZTE0MTk4NDdlMWNjIiBJc3N1ZUluc3RhbnQ9IjIwMjAtMDktMjRUMDA6NTM6Mjgu\r\n" + 
			"OTU1WiIgVmVyc2lvbj0iMi4wIj48c2FtbDI6SXNzdWVyIHhtbG5zOnNhbWwyPSJ1cm46b2FzaXM6\r\n" + 
			"bmFtZXM6dGM6U0FNTDoyLjA6YXNzZXJ0aW9uIj5odHRwczovLzEzMy4xMzMuMTM1LjM1L3dlYnNz\r\n" + 
			"by9TQU1MMi9NZXRhZGF0YS92c3BoZXJlLnRlc3Q8L3NhbWwyOklzc3Vlcj48c2FtbDJwOlN0YXR1\r\n" + 
			"cz48c2FtbDJwOlN0YXR1c0NvZGUgVmFsdWU9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDpz\r\n" + 
			"dGF0dXM6U3VjY2VzcyIvPjxzYW1sMnA6U3RhdHVzTWVzc2FnZT5SZXF1ZXN0IHN1Y2Nlc3NmdWw8\r\n" + 
			"L3NhbWwycDpTdGF0dXNNZXNzYWdlPjwvc2FtbDJwOlN0YXR1cz48c2FtbDI6QXNzZXJ0aW9uIHht\r\n" + 
			"bG5zOnNhbWwyPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6YXNzZXJ0aW9uIiBJRD0iXzk5\r\n" + 
			"M2RlM2Y4LWM1ZGUtNDJlNS04NTBhLWE1NzdlZmY4NjUwNyIgSXNzdWVJbnN0YW50PSIyMDIwLTA5\r\n" + 
			"LTI0VDAwOjUzOjI4Ljg4NloiIFZlcnNpb249IjIuMCIgeG1sbnM6eHNkPSJodHRwOi8vd3d3Lncz\r\n" + 
			"Lm9yZy8yMDAxL1hNTFNjaGVtYSIgeG1sbnM6eHNpPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hN\r\n" + 
			"TFNjaGVtYS1pbnN0YW5jZSI+PHNhbWwyOklzc3VlciBGb3JtYXQ9InVybjpvYXNpczpuYW1lczp0\r\n" + 
			"YzpTQU1MOjIuMDpuYW1laWQtZm9ybWF0OmVudGl0eSI+aHR0cHM6Ly8xMzMuMTMzLjEzNS4zNS93\r\n" + 
			"ZWJzc28vU0FNTDIvTWV0YWRhdGEvdnNwaGVyZS50ZXN0PC9zYW1sMjpJc3N1ZXI+PGRzOlNpZ25h\r\n" + 
			"dHVyZSB4bWxuczpkcz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnIyI+PGRzOlNp\r\n" + 
			"Z25lZEluZm8+PGRzOkNhbm9uaWNhbGl6YXRpb25NZXRob2QgQWxnb3JpdGhtPSJodHRwOi8vd3d3\r\n" + 
			"LnczLm9yZy8yMDAxLzEwL3htbC1leGMtYzE0biMiLz48ZHM6U2lnbmF0dXJlTWV0aG9kIEFsZ29y\r\n" + 
			"aXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8wNC94bWxkc2lnLW1vcmUjcnNhLXNoYTI1NiIv\r\n" + 
			"PjxkczpSZWZlcmVuY2UgVVJJPSIjXzk5M2RlM2Y4LWM1ZGUtNDJlNS04NTBhLWE1NzdlZmY4NjUw\r\n" + 
			"NyI+PGRzOlRyYW5zZm9ybXM+PGRzOlRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMu\r\n" + 
			"b3JnLzIwMDAvMDkveG1sZHNpZyNlbnZlbG9wZWQtc2lnbmF0dXJlIi8+PGRzOlRyYW5zZm9ybSBB\r\n" + 
			"bGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMTAveG1sLWV4Yy1jMTRuIyI+PGVjOklu\r\n" + 
			"Y2x1c2l2ZU5hbWVzcGFjZXMgeG1sbnM6ZWM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMTAveG1s\r\n" + 
			"LWV4Yy1jMTRuIyIgUHJlZml4TGlzdD0ieHNkIHhzaSIvPjwvZHM6VHJhbnNmb3JtPjwvZHM6VHJh\r\n" + 
			"bnNmb3Jtcz48ZHM6RGlnZXN0TWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAw\r\n" + 
			"MS8wNC94bWxlbmMjc2hhMjU2Ii8+PGRzOkRpZ2VzdFZhbHVlPnlpaTB0Y2RQQUpCbW1uSlo2c1kr\r\n" + 
			"SUF3U00wUDhOR1RsbXo3M1B1b203OWc9PC9kczpEaWdlc3RWYWx1ZT48L2RzOlJlZmVyZW5jZT48\r\n" + 
			"L2RzOlNpZ25lZEluZm8+PGRzOlNpZ25hdHVyZVZhbHVlPm5PZzRaUVNMRmk2WmtDTHdGaEw3QVZJ\r\n" + 
			"SzhKeGQyd2M5U1U5Q0hOMnpBeENKWXp1TlRhNVdXWHk0RFdNR0MwOExHb01ranMreE04dXcKQXRu\r\n" + 
			"VllsUmYyYVlraWtHRTNrYlZqTDM1RzRxaUpHZXFTSFdnZ0RTUlNmOFpyQUhaQytWRElWMGdpTFJC\r\n" + 
			"OGhtTVZ6MkNULzFiMG5QZQp1d0hVU1M1QW9JQmlvSXlBOFIwSldjQnIvNWl0dTdqWkpxZlZsOHNP\r\n" + 
			"THAzNTk5UUdjYXpyOUpNNEVENUNKdGIzWU5RT0tNemxhRXFGCkp6cTZRUDJRUDh1OE9TNHVnQmRR\r\n" + 
			"V25PbUYyMi9DVzkrSHJaOWE4WTBFVHpLNUtyZm12dUcrWTg2eDVYNHJzb1VqVDM2eTFFaFFmNE0K\r\n" + 
			"c3JTVGZrS1E0RzQxQ3ErMUFjVEs1VUdtc0JkNlRXT2NWTVpuTWc9PTwvZHM6U2lnbmF0dXJlVmFs\r\n" + 
			"dWU+PGRzOktleUluZm8+PGRzOlg1MDlEYXRhPjxkczpYNTA5Q2VydGlmaWNhdGU+TUlJRDBqQ0NB\r\n" + 
			"cnFnQXdJQkFnSUpBTlJsRzhOZjlPdTlNQTBHQ1NxR1NJYjNEUUVCQ3dVQU1JR1VNUXN3Q1FZRFZR\r\n" + 
			"UUREQUpEUVRFWApNQlVHQ2dtU0pvbVQ4aXhrQVJrV0IzWnpjR2hsY21VeEZEQVNCZ29Ka2lhSmsv\r\n" + 
			"SXNaQUVaRmdSMFpYTjBNUXN3Q1FZRFZRUUdFd0pWClV6RVRNQkVHQTFVRUNBd0tRMkZzYVdadmNt\r\n" + 
			"NXBZVEVYTUJVR0ExVUVDZ3dPY0dodmRHOXVMVzFoWTJocGJtVXhHekFaQmdOVkJBc00KRWxaTmQy\r\n" + 
			"RnlaU0JGYm1kcGJtVmxjbWx1WnpBZUZ3MHlNREF6TXpFd09ETXdNVEJhRncwek1EQXpNall3T0RN\r\n" + 
			"NU5EVmFNQmd4RmpBVQpCZ05WQkFNTURYTnpiM05sY25abGNsTnBaMjR3Z2dFaU1BMEdDU3FHU0li\r\n" + 
			"M0RRRUJBUVVBQTRJQkR3QXdnZ0VLQW9JQkFRQ3VsSDkwCkxYVlpvOUhRNm1Nc3NQOWpUS0dnWTYw\r\n" + 
			"TktOQTA0YzFqMXRvaGFwUm1XWDF3TE9GTWl5SkdoaEgyWW14Nzk5Y0ZSenB5V08raG5TdjQKdjBp\r\n" + 
			"elN3N21nRWpZRjdQUFpZUjFXU1RTRTU3WXE4T2hPSXlKcjJVZ3NMNytZRHp6YlBid1hSWDlGOCtN\r\n" + 
			"akpPUGs5ZVBvYUxpWXFQSApvMlRwdjlyUmZwaG95Y29SeFFBc2VWNjB2WWoxbFpWdUd0RkhlYjlh\r\n" + 
			"MkkrVjBoYjBjQmFJN0dqRE42bU8wcjRTekNHZzBZUmtabkkvCkJJNkU3ekFjVlhJeTZONFoySUU4\r\n" + 
			"amZPd1lNZUN6bWU4QWU3b1lFRzdtQmtaZFp4dVRBMEJqWjUvMlFpTEtVUW1TcDh3WkIxUVBwVEwK\r\n" + 
			"OEZLZDhsZFhRY1RYSVRJTGlDNWtBRlh2QzU0NmtCc3pBZ01CQUFHamdhRXdnWjR3Q3dZRFZSMFBC\r\n" + 
			"QVFEQWdYZ01BOEdBMVVkRVFRSQpNQWFIQklXRmh5TXdIUVlEVlIwT0JCWUVGTEh1TlVEcHRhb2k0\r\n" + 
			"VG8rWjFFT0J4TzNPNEFyTUI4R0ExVWRJd1FZTUJhQUZKT09VeStEClNxYTFLWkIxblBHZ1A4djlJ\r\n" + 
			"T3JGTUQ0R0NDc0dBUVVGQndFQkJESXdNREF1QmdnckJnRUZCUWN3QW9ZaWFIUjBjSE02THk4eE16\r\n" + 
			"TXUKTVRNekxqRXpOUzR6TlM5aFptUXZkbVZqY3k5allUQU5CZ2txaGtpRzl3MEJBUXNGQUFPQ0FR\r\n" + 
			"RUFBTDNVaTM5bHc1UnZKcElreXVLRQpJaWR4d1BzVDFGblZRdHBBYjV1bEl2TVk5bkVxMURXSWtk\r\n" + 
			"bHB3RUp3djRuc2VIa3ZkVUw4NXF0ZjBKZmgzUlNGb3lFZzZmelFpZE9pCjkxb1NEeDBRSFlLRytx\r\n" + 
			"NGZUTGR5TTRYaHpiL3dORXh2eGEya3gzMlpaK1d1VTNUMVVpTnM0UStqZWJXTVZLejk1a1l3OXZW\r\n" + 
			"STRMamYKUGt0TW1uamx4R0lHNmtHeDlGeWNQQWlZOU5Pb293REcySUtGclBWOEU5REJIVGkxd0R3\r\n" + 
			"OTBIeXNiQzl3b2xCeUJIRW9lWGxxekRWVgo4WFhRWEVPSUtHbDBibUt3R1VsakRHZFVONjRqSndj\r\n" + 
			"VCtIeDRuVTBJTnFiR0F1bjMwYi9EQUlqK0gxaWVGUHBhTGhUcXB0TDU3dTJMCkxidXI0SXJIaUZh\r\n" + 
			"bjlCN3U0QT09PC9kczpYNTA5Q2VydGlmaWNhdGU+PGRzOlg1MDlDZXJ0aWZpY2F0ZT5NSUlFRXpD\r\n" + 
			"Q0F2dWdBd0lCQWdJSkFQOVJhQ2FVa3hmVk1BMEdDU3FHU0liM0RRRUJDd1VBTUlHVU1Rc3dDUVlE\r\n" + 
			"VlFRRERBSkRRVEVYCk1CVUdDZ21TSm9tVDhpeGtBUmtXQjNaemNHaGxjbVV4RkRBU0Jnb0praWFK\r\n" + 
			"ay9Jc1pBRVpGZ1IwWlhOME1Rc3dDUVlEVlFRR0V3SlYKVXpFVE1CRUdBMVVFQ0F3S1EyRnNhV1p2\r\n" + 
			"Y201cFlURVhNQlVHQTFVRUNnd09jR2h2ZEc5dUxXMWhZMmhwYm1VeEd6QVpCZ05WQkFzTQpFbFpO\r\n" + 
			"ZDJGeVpTQkZibWRwYm1WbGNtbHVaekFlRncweU1EQXpNamd3T0RNNU5EVmFGdzB6TURBek1qWXdP\r\n" + 
			"RE01TkRWYU1JR1VNUXN3CkNRWURWUVFEREFKRFFURVhNQlVHQ2dtU0pvbVQ4aXhrQVJrV0IzWnpj\r\n" + 
			"R2hsY21VeEZEQVNCZ29Ka2lhSmsvSXNaQUVaRmdSMFpYTjAKTVFzd0NRWURWUVFHRXdKVlV6RVRN\r\n" + 
			"QkVHQTFVRUNBd0tRMkZzYVdadmNtNXBZVEVYTUJVR0ExVUVDZ3dPY0dodmRHOXVMVzFoWTJocApi\r\n" + 
			"bVV4R3pBWkJnTlZCQXNNRWxaTmQyRnlaU0JGYm1kcGJtVmxjbWx1WnpDQ0FTSXdEUVlKS29aSWh2\r\n" + 
			"Y05BUUVCQlFBRGdnRVBBRENDCkFRb0NnZ0VCQU9MQXVZdEpzdFFWdVhncGROQkkrZGFmL1pUdTVj\r\n" + 
			"VFB5Mk91VE1FaHVIbDJKZGhSVzVhQm9SSzhNU3Zha0lLRGRPR2wKb2JnNjQ1aHZnUEVjanJTcm02\r\n" + 
			"N3krTmRhV2xZdlhsTlZka1BXbTNpcEcrdnV6OER3R3pOZWFWRnhuVHd6eUVpLzI1SDk5ektSa0tm\r\n" + 
			"YwpYVUs5dmpLNlFWQzBEVlRMWlY3Z0Mvbk9yMlpUUHZEeFhBNlVHRFB4YTB4N3Q3TEFMeGpuSTdk\r\n" + 
			"YXgrSjRkd1FtUnIrcjM0dW9vamZyCjNtY1V6dUNuNERpWE1pb1pwcWZ4YlIvZmFoc0xuK1V0UUdo\r\n" + 
			"MkpzVHlEQlFVRVhjN2dZTk5OaDUveXkxVVFwdTlwT3RkajArTXlaY2YKU2ppUEloZ3RXeWJXNkFk\r\n" + 
			"YVRlREg1RkdGa2Y3dzY5aXRiQTllUmF1dVFrdXhJd01DQXdFQUFhTm1NR1F3SFFZRFZSME9CQllF\r\n" + 
			"RkpPTwpVeStEU3FhMUtaQjFuUEdnUDh2OUlPckZNQjhHQTFVZEVRUVlNQmFCRG1WdFlXbHNRR0Zq\r\n" + 
			"YldVdVkyOXRod1IvQUFBQk1BNEdBMVVkCkR3RUIvd1FFQXdJQkJqQVNCZ05WSFJNQkFmOEVDREFH\r\n" + 
			"QVFIL0FnRUFNQTBHQ1NxR1NJYjNEUUVCQ3dVQUE0SUJBUUJYLzNJcUtvSlcKdFROdzdnNE5FVXhn\r\n" + 
			"bjFwcVV1TWVWWUI5T1F2NjBnZlNENy9SZGxmQWh6b1V0Q1J3MEVPMzd2dXRQcktHeWZkUU9PZjdv\r\n" + 
			"UkY4RGY4RgpPeDRhYlNWTi9randXNVlSOUtpOVhseGozVjB6UEVLKythZWJwSlVkUUJNV3lwRzRC\r\n" + 
			"MW5mbGNlU2lNNnlRaVo5NDUvcXN6VXZoVzBoCkVONXY0YXUwbEF2MjhxbU5HSkEzaEthaTVvNnAr\r\n" + 
			"WjZuVGF0TElHSXROYjVkT2JuNHIwdHBwTzdCSnYrY0hXT1hUSlFZV0lKSnByVTEKL1FPT0FPaVhH\r\n" + 
			"MEpkRjdBNWd4RDNuZ21wb3NIM21wUHN0dkE2WS93RU5oZVNOU25XL1NDWnNZSkxzSmJLU1F0YjY2\r\n" + 
			"bG00OC9odHRCMApxa1F6UnhVNDRUZnpLandpK0xHcVBmanEyYnFlPC9kczpYNTA5Q2VydGlmaWNh\r\n" + 
			"dGU+PC9kczpYNTA5RGF0YT48L2RzOktleUluZm8+PC9kczpTaWduYXR1cmU+PHNhbWwyOlN1Ympl\r\n" + 
			"Y3Q+PHNhbWwyOk5hbWVJRCBGb3JtYXQ9Imh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL2NsYWlt\r\n" + 
			"cy9VUE4iPkFkbWluaXN0cmF0b3JAVlNQSEVSRS5URVNUPC9zYW1sMjpOYW1lSUQ+PHNhbWwyOlN1\r\n" + 
			"YmplY3RDb25maXJtYXRpb24gTWV0aG9kPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6Y206\r\n" + 
			"YmVhcmVyIj48c2FtbDI6U3ViamVjdENvbmZpcm1hdGlvbkRhdGEgSW5SZXNwb25zZVRvPSJfNTM5\r\n" + 
			"YTI0Zjc1Y2Q4YjhkMGJmNzFlMTQxOTg0N2UxY2MiIE5vdE9uT3JBZnRlcj0iMjAyMC0wOS0yNFQw\r\n" + 
			"MDo1NzoxMy44NzVaIiBSZWNpcGllbnQ9Imh0dHBzOi8vMTMzLjEzMy4xMzUuMzUvdWkvc2FtbC93\r\n" + 
			"ZWJzc28vc3NvIi8+PC9zYW1sMjpTdWJqZWN0Q29uZmlybWF0aW9uPjwvc2FtbDI6U3ViamVjdD48\r\n" + 
			"c2FtbDI6Q29uZGl0aW9ucyBOb3RCZWZvcmU9IjIwMjAtMDktMjRUMDA6NTI6MTMuODc1WiIgTm90\r\n" + 
			"T25PckFmdGVyPSIyMDIwLTA5LTI0VDAwOjU3OjEzLjg3NVoiPjxzYW1sMjpQcm94eVJlc3RyaWN0\r\n" + 
			"aW9uIENvdW50PSIxMCIvPjxzYW1sMjpDb25kaXRpb24gQ291bnQ9IjEwIiB4bWxuczpyc2E9Imh0\r\n" + 
			"dHA6Ly93d3cucnNhLmNvbS9uYW1lcy8yMDA5LzEyL3N0ZC1leHQvU0FNTDIuMCIgeHNpOnR5cGU9\r\n" + 
			"InJzYTpSZW5ld1Jlc3RyaWN0aW9uVHlwZSIvPjxzYW1sMjpBdWRpZW5jZVJlc3RyaWN0aW9uPjxz\r\n" + 
			"YW1sMjpBdWRpZW5jZT5odHRwczovLzEzMy4xMzMuMTM1LjM1L3VpL3NhbWwvd2Vic3NvL21ldGFk\r\n" + 
			"YXRhPC9zYW1sMjpBdWRpZW5jZT48L3NhbWwyOkF1ZGllbmNlUmVzdHJpY3Rpb24+PC9zYW1sMjpD\r\n" + 
			"b25kaXRpb25zPjxzYW1sMjpBdXRoblN0YXRlbWVudCBBdXRobkluc3RhbnQ9IjIwMjAtMDktMjRU\r\n" + 
			"MDA6NTM6MjguODc1WiIgU2Vzc2lvbkluZGV4PSJfZGFmNmU3NWEwZjFmOGE3MjcyNGMyYTFkOTIy\r\n" + 
			"MmU3N2YiIFNlc3Npb25Ob3RPbk9yQWZ0ZXI9IjIwMjAtMDktMjRUMDg6NDE6NTMuMDcxWiI+PHNh\r\n" + 
			"bWwyOkF1dGhuQ29udGV4dD48c2FtbDI6QXV0aG5Db250ZXh0Q2xhc3NSZWY+dXJuOm9hc2lzOm5h\r\n" + 
			"bWVzOnRjOlNBTUw6Mi4wOmFjOmNsYXNzZXM6UGFzc3dvcmRQcm90ZWN0ZWRUcmFuc3BvcnQ8L3Nh\r\n" + 
			"bWwyOkF1dGhuQ29udGV4dENsYXNzUmVmPjwvc2FtbDI6QXV0aG5Db250ZXh0Pjwvc2FtbDI6QXV0\r\n" + 
			"aG5TdGF0ZW1lbnQ+PHNhbWwyOkF0dHJpYnV0ZVN0YXRlbWVudD48c2FtbDI6QXR0cmlidXRlIEZy\r\n" + 
			"aWVuZGx5TmFtZT0idXNlclByaW5jaXBhbE5hbWUiIE5hbWU9Imh0dHA6Ly9zY2hlbWFzLnhtbHNv\r\n" + 
			"YXAub3JnL2NsYWltcy9VUE4iIE5hbWVGb3JtYXQ9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIu\r\n" + 
			"MDphdHRybmFtZS1mb3JtYXQ6dXJpIj48c2FtbDI6QXR0cmlidXRlVmFsdWUgeHNpOnR5cGU9Inhz\r\n" + 
			"ZDpzdHJpbmciPkFkbWluaXN0cmF0b3JAVlNQSEVSRS5URVNUPC9zYW1sMjpBdHRyaWJ1dGVWYWx1\r\n" + 
			"ZT48L3NhbWwyOkF0dHJpYnV0ZT48c2FtbDI6QXR0cmlidXRlIEZyaWVuZGx5TmFtZT0iU3ViamVj\r\n" + 
			"dCBUeXBlIiBOYW1lPSJodHRwOi8vdm13YXJlLmNvbS9zY2hlbWFzL2F0dHItbmFtZXMvMjAxMS8w\r\n" + 
			"Ny9pc1NvbHV0aW9uIiBOYW1lRm9ybWF0PSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6YXR0\r\n" + 
			"cm5hbWUtZm9ybWF0OnVyaSI+PHNhbWwyOkF0dHJpYnV0ZVZhbHVlIHhzaTp0eXBlPSJ4c2Q6c3Ry\r\n" + 
			"aW5nIj5mYWxzZTwvc2FtbDI6QXR0cmlidXRlVmFsdWU+PC9zYW1sMjpBdHRyaWJ1dGU+PHNhbWwy\r\n" + 
			"OkF0dHJpYnV0ZSBGcmllbmRseU5hbWU9ImdpdmVuTmFtZSIgTmFtZT0iaHR0cDovL3NjaGVtYXMu\r\n" + 
			"eG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvZ2l2ZW5uYW1lIiBOYW1lRm9y\r\n" + 
			"bWF0PSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6YXR0cm5hbWUtZm9ybWF0OnVyaSI+PHNh\r\n" + 
			"bWwyOkF0dHJpYnV0ZVZhbHVlIHhzaTp0eXBlPSJ4c2Q6c3RyaW5nIj5BZG1pbmlzdHJhdG9yPC9z\r\n" + 
			"YW1sMjpBdHRyaWJ1dGVWYWx1ZT48L3NhbWwyOkF0dHJpYnV0ZT48c2FtbDI6QXR0cmlidXRlIEZy\r\n" + 
			"aWVuZGx5TmFtZT0iR3JvdXBzIiBOYW1lPSJodHRwOi8vcnNhLmNvbS9zY2hlbWFzL2F0dHItbmFt\r\n" + 
			"ZXMvMjAwOS8wMS9Hcm91cElkZW50aXR5IiBOYW1lRm9ybWF0PSJ1cm46b2FzaXM6bmFtZXM6dGM6\r\n" + 
			"U0FNTDoyLjA6YXR0cm5hbWUtZm9ybWF0OnVyaSI+PHNhbWwyOkF0dHJpYnV0ZVZhbHVlIHhzaTp0\r\n" + 
			"eXBlPSJ4c2Q6c3RyaW5nIj52c3BoZXJlLnRlc3RcVXNlcnM8L3NhbWwyOkF0dHJpYnV0ZVZhbHVl\r\n" + 
			"PjxzYW1sMjpBdHRyaWJ1dGVWYWx1ZSB4c2k6dHlwZT0ieHNkOnN0cmluZyI+dnNwaGVyZS50ZXN0\r\n" + 
			"XEFkbWluaXN0cmF0b3JzPC9zYW1sMjpBdHRyaWJ1dGVWYWx1ZT48c2FtbDI6QXR0cmlidXRlVmFs\r\n" + 
			"dWUgeHNpOnR5cGU9InhzZDpzdHJpbmciPnZzcGhlcmUudGVzdFxDQUFkbWluczwvc2FtbDI6QXR0\r\n" + 
			"cmlidXRlVmFsdWU+PHNhbWwyOkF0dHJpYnV0ZVZhbHVlIHhzaTp0eXBlPSJ4c2Q6c3RyaW5nIj52\r\n" + 
			"c3BoZXJlLnRlc3RcQ29tcG9uZW50TWFuYWdlci5BZG1pbmlzdHJhdG9yczwvc2FtbDI6QXR0cmli\r\n" + 
			"dXRlVmFsdWU+PHNhbWwyOkF0dHJpYnV0ZVZhbHVlIHhzaTp0eXBlPSJ4c2Q6c3RyaW5nIj52c3Bo\r\n" + 
			"ZXJlLnRlc3RcU3lzdGVtQ29uZmlndXJhdGlvbi5CYXNoU2hlbGxBZG1pbmlzdHJhdG9yczwvc2Ft\r\n" + 
			"bDI6QXR0cmlidXRlVmFsdWU+PHNhbWwyOkF0dHJpYnV0ZVZhbHVlIHhzaTp0eXBlPSJ4c2Q6c3Ry\r\n" + 
			"aW5nIj52c3BoZXJlLnRlc3RcU3lzdGVtQ29uZmlndXJhdGlvbi5BZG1pbmlzdHJhdG9yczwvc2Ft\r\n" + 
			"bDI6QXR0cmlidXRlVmFsdWU+PHNhbWwyOkF0dHJpYnV0ZVZhbHVlIHhzaTp0eXBlPSJ4c2Q6c3Ry\r\n" + 
			"aW5nIj52c3BoZXJlLnRlc3RcTGljZW5zZVNlcnZpY2UuQWRtaW5pc3RyYXRvcnM8L3NhbWwyOkF0\r\n" + 
			"dHJpYnV0ZVZhbHVlPjxzYW1sMjpBdHRyaWJ1dGVWYWx1ZSB4c2k6dHlwZT0ieHNkOnN0cmluZyI+\r\n" + 
			"dnNwaGVyZS50ZXN0XEV2ZXJ5b25lPC9zYW1sMjpBdHRyaWJ1dGVWYWx1ZT48L3NhbWwyOkF0dHJp\r\n" + 
			"YnV0ZT48c2FtbDI6QXR0cmlidXRlIEZyaWVuZGx5TmFtZT0ic3VybmFtZSIgTmFtZT0iaHR0cDov\r\n" + 
			"L3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvc3VybmFtZSIg\r\n" + 
			"TmFtZUZvcm1hdD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmF0dHJuYW1lLWZvcm1hdDp1\r\n" + 
			"cmkiPjxzYW1sMjpBdHRyaWJ1dGVWYWx1ZSB4c2k6dHlwZT0ieHNkOnN0cmluZyI+dnNwaGVyZS50\r\n" + 
			"ZXN0PC9zYW1sMjpBdHRyaWJ1dGVWYWx1ZT48L3NhbWwyOkF0dHJpYnV0ZT48L3NhbWwyOkF0dHJp\r\n" + 
			"YnV0ZVN0YXRlbWVudD48L3NhbWwyOkFzc2VydGlvbj48L3NhbWwycDpSZXNwb25zZT4=";
	
	public static void main(String[] args) throws Exception {
		System.out.println(URLEncoder.encode(value, "utf-8"));
	}
}
